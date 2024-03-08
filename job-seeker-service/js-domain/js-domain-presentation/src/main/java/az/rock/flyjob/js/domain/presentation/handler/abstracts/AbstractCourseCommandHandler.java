package az.rock.flyjob.js.domain.presentation.handler.abstracts;


import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;
import com.intellibucket.lib.payload.event.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.delete.CourseDeleteEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractCourseCommandHandler {

    CourseMergeEvent create(CourseCommandModel command);

    CourseMergeEvent merge(CourseCommandModel command,UUID id);

    CourseDeleteEvent delete(UUID id);

    CourseFileEvent uploadCertificate(UUID courseId, MultipartFileWrapper file);

    CourseMergeEvent reorder(ReorderCommandModel reorderCommandModel);
}
