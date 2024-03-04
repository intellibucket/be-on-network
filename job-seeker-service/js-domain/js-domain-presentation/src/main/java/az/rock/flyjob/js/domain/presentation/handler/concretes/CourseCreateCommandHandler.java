package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCreateCommandHandler;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseCreatedEvent;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.event.update.CourseUpdateEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseCreateCommandHandler implements AbstractCourseCreateCommandHandler {


//    private final AbstractCourseDomainMapper courseDomainMapper;
//    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    @Override
    public CourseCreatedEvent createCourse(CourseCommandModel command) {
        return null;
    }

    @Override
    public CourseUpdateEvent updateCourse(CourseCommandModel command) {
        return null;
    }

    @Override
    public CourseDeleteEvent deleteCourse(UUID id) {
        return null;
    }

    @Override
    public CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) {
        return null;
    }
}

