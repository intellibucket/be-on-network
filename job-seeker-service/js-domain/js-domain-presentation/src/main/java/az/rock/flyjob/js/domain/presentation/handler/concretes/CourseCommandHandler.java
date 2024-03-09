package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.exception.CourseDomainException;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.payload.CourseFilePayload;
import com.intellibucket.lib.payload.payload.CourseMergePayload;
import com.intellibucket.lib.payload.payload.CourseDeletedPayload;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class CourseCommandHandler implements AbstractCourseCommandHandler {
    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;
    private final AbstractCourseDomainMapper courseDomainMapper;
    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractSecurityContextHolder securityContextHolder;

    public CourseCommandHandler(AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter, AbstractCourseDomainMapper courseDomainMapper, AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter, AbstractFileStorageAdapter fileStorageService, AbstractSecurityContextHolder securityContextHolder) {
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
        this.courseDomainMapper = courseDomainMapper;
        this.courseCommandRepositoryAdapter = courseCommandRepositoryAdapter;
        this.fileStorageService = fileStorageService;
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public CourseMergeEvent create(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command, securityContextHolder.availableResumeID());
        if(courseQueryRepositoryAdapter.existsByEquality(newCourseRoot))
            throw new CourseDomainException("F0000000004");
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseMergeEvent.of(CourseMergePayload.of(optionalCourseRoot.orElseThrow(CourseDomainException::new).getRootID().getRootID()));
    }

    @Override
    public CourseMergeEvent merge(CourseCommandModel command,UUID id) {
        var oldCourse = courseQueryRepositoryAdapter.findById(CourseID.of(id));
        if(oldCourse.isEmpty())throw new CourseDomainException("F0000000003");
        var course = courseDomainMapper.toRoot(command,oldCourse.get());
        if(courseQueryRepositoryAdapter.existsByEquality(course))
            throw new CourseDomainException("F0000000004");
        courseCommandRepositoryAdapter.update(course);
        return CourseMergeEvent.of(CourseMergePayload.of(id));
    }

    @Override
    public CourseDeleteEvent delete(UUID id) {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(id));
        if(optional.isEmpty())throw new CourseDomainException("F0000000003");
        this.courseCommandRepositoryAdapter.inActive(optional.get());
        return CourseDeleteEvent.of(CourseDeletedPayload.of(id));
    }

    @Override
    public CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(courseId));
        if(optional.isEmpty())throw new CourseDomainException("F0000000003");
        var savedFile = fileStorageService.uploadFile(file);
        var course = optional.get();
        course.setCertificateFilePath(savedFile.getObject());
        this.courseCommandRepositoryAdapter.update(course);
        return CourseFileEvent.of(CourseFilePayload.of(courseId));
    }

    @Override
    public CourseMergeEvent reorder(ReorderCommandModel reorderCommandModel) {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(reorderCommandModel.getTargetId()));
        if(optional.isEmpty())throw new CourseDomainException("F0000000003");
        var course = optional.get();
        course.setOrderNumber(reorderCommandModel.getOrderNumber());
        courseCommandRepositoryAdapter.update(course);
        return CourseMergeEvent.of(CourseMergePayload.of(reorderCommandModel.getTargetId()));
    }

}
