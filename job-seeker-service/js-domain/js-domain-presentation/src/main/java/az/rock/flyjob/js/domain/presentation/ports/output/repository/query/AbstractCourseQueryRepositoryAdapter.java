package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.create.CourseFileEvent;

import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractCourseQueryRepositoryAdapter {

    Boolean existsByTitleAndResumeExceptCurrentCourse(String courseName, ResumeID resumeID,CourseID courseID);

    Optional<CourseRoot> findById(CourseID courseID);
}
