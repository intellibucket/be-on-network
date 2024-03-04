package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.service.abstracts.AbstractCourseDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.exception.CourseDomainException;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractResumeQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.payload.CourseMergePayload;
import com.intellibucket.lib.payload.payload.CourseDeletedPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseCreateCommandHandler implements AbstractCourseCreateCommandHandler {

    private final AbstractCourseDomainService courseDomainService;
    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;
    private final AbstractCourseDomainMapper courseDomainMapper;
    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    private final AbstractSecurityContextHolder securityContextHolder;

    public CourseCreateCommandHandler(AbstractCourseDomainService courseDomainService, AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter, AbstractCourseDomainMapper courseDomainMapper, AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter, AbstractSecurityContextHolder securityContextHolder) {
        this.courseDomainService = courseDomainService;
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
        this.courseDomainMapper = courseDomainMapper;
        this.courseCommandRepositoryAdapter = courseCommandRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public CourseMergeEvent mergeCourse(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command,securityContextHolder.availableResumeID());
        //TODO CHECK COURSE FOR SAME NAME IN SAME RESUME
        this.courseQueryRepositoryAdapter.existsByTitleAndResume(newCourseRoot.getCourseTitle(),newCourseRoot.getResume().getAbsoluteID());
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.merge(newCourseRoot);
        return CourseMergeEvent.of(
                CourseMergePayload.of(
                        optionalCourseRoot.orElseThrow(CourseDomainException::new).getRootID().getRootID()
                )
        );
    }

    @Override
    public CourseDeleteEvent deleteCourse(UUID id) {

        var optionalCourseRoot = this.courseCommandRepositoryAdapter.delete(id);
        return CourseDeleteEvent.of(
                CourseDeletedPayload.of(
                        optionalCourseRoot.orElseThrow(CourseDomainException::new).getRootID().getRootID()
                )
        );
    }

    @Override
    public CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) {

        return null;
    }
}

