package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;

import java.util.Optional;

@DomainOutputPort
public interface AbstractCourseQueryRepositoryAdapter {

    Boolean existsByEquality(String courseName, ResumeID resumeID, CourseID courseID);

    Optional<CourseRoot> findById(CourseID courseID);
}
