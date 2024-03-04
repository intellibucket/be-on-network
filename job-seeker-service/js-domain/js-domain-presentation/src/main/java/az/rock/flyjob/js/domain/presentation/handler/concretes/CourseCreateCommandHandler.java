package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseCreatedEvent;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.event.update.CourseUpdateEvent;
import com.intellibucket.lib.payload.payload.CourseCreatedPayload;
import com.intellibucket.lib.payload.payload.CourseDeletedPayload;
import com.intellibucket.lib.payload.payload.CourseUpdatedPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseCreateCommandHandler implements AbstractCourseCreateCommandHandler {


    private final AbstractCourseDomainMapper courseDomainMapper;  //todo
    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    public CourseCreateCommandHandler(AbstractCourseDomainMapper courseDomainMapper, AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter) {
        this.courseDomainMapper = courseDomainMapper;
        this.courseCommandRepositoryAdapter = courseCommandRepositoryAdapter;
    }

    @Override
    public CourseCreatedEvent createCourse(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command);
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseCreatedEvent.of(
                CourseCreatedPayload.of(
                        optionalCourseRoot.orElseThrow(()->new RuntimeException()).getRootID().getRootID()
                )
        );
    }

    @Override
    public CourseUpdateEvent updateCourse(CourseCommandModel command) {
        var newCourseRoot = this.courseDomainMapper.toRoot(command);
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseUpdateEvent.of(
                CourseUpdatedPayload.of(
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

