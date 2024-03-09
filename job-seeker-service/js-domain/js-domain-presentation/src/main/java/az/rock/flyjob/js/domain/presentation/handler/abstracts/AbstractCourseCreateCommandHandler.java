package az.rock.flyjob.js.domain.presentation.handler.abstracts;


import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)//TODO rollback ?
public interface AbstractCourseCreateCommandHandler {

    CourseMergeEvent mergeCourse(CourseCommandModel command);

    CourseDeleteEvent deleteCourse(UUID id);

    CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file);
}
