package az.rock.flyjob.js.domain.presentation.handler.concretes;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.exception.CourseDomainException;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.payload.CourseFilePayload;
import com.intellibucket.lib.payload.payload.CourseMergePayload;
import com.intellibucket.lib.payload.payload.CourseDeletedPayload;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CourseCommandHandler implements AbstractCourseCreateCommandHandler {
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
    public CourseMergeEvent createCourse(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command,
//                securityContextHolder.availableResumeID()
                ResumeID.of(UUID.fromString("e66d06d5-d2f6-41d0-b7ed-3466f079bdbc"))
        );

        if(this.courseQueryRepositoryAdapter.existsByTitleAndResume(newCourseRoot.getCourseTitle(),newCourseRoot.getResume().getAbsoluteID()))
            throw new CourseDomainException("F0000000002");

        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseMergeEvent.of(
                CourseMergePayload.of(
                        optionalCourseRoot.orElseThrow(CourseDomainException::new).getRootID().getRootID()
                )
        );
    }
    @Override
    public CourseMergeEvent updateCourse(CourseCommandModel command,UUID id) {
        var oldCourse = courseQueryRepositoryAdapter.findById(CourseID.of(id));
        if(oldCourse.isEmpty())throw new RuntimeException("");
        var course = courseDomainMapper.toRoot(command,oldCourse.get());
        courseCommandRepositoryAdapter.update(course);
        return CourseMergeEvent.of(
                CourseMergePayload.of(
                       id
                )
        );
    }



    @Override
    public CourseDeleteEvent deleteCourse(UUID id) {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(id));
        if(optional.isEmpty())throw new RuntimeException("");
        this.courseCommandRepositoryAdapter.inActive(optional.get());
        return CourseDeleteEvent.of(
                CourseDeletedPayload.of(
                        id
                )
        );
    }

    @Override
    public CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) {
        var savedFile = fileStorageService.uploadFile(file);
        var root = courseCommandRepositoryAdapter.updateCertificatePath(courseId, savedFile.getObject());
        return CourseFileEvent.of(CourseFilePayload.of(courseId));
    }
}

