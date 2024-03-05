package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;


import az.rock.lib.annotation.DomainOutputPort;
import java.util.UUID;

@DomainOutputPort
public interface AbstractCourseQueryRepositoryAdapter {

    Boolean existsByTitleAndResume(String courseName, UUID resumeID);
}
