package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
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


    private final AbstractCourseDomainMapper courseDomainMapper;  //todo
    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    private final AbstractSecurityContextHolder securityContextHolder;

    public CourseCreateCommandHandler(AbstractCourseDomainMapper courseDomainMapper, AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter, AbstractSecurityContextHolder securityContextHolder) {
        this.courseDomainMapper = courseDomainMapper;
        this.courseCommandRepositoryAdapter = courseCommandRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public CourseMergeEvent mergeCourse(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command,securityContextHolder.availableResumeID());
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseMergeEvent.of(
                CourseMergePayload.of(
                        optionalCourseRoot.orElseThrow(()->new RuntimeException()).getRootID().getRootID()
                )
        );
    }

    @Override
    public CourseDeleteEvent deleteCourse(UUID id) {

        var optionalCourseRoot = this.courseCommandRepositoryAdapter.delete(id);
        return CourseDeleteEvent.of(
                CourseDeletedPayload.of(
                        optionalCourseRoot.orElseThrow(()->new RuntimeException()).getRootID().getRootID()
                )
        );
    }

    @Override
    public CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) {

        return null;
    }
}

