package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface AbstractCourseCommandRepositoryAdapter {
    Optional<CourseRoot> create(CourseRoot root);
    Optional<CourseRoot> update(CourseRoot root);
    Optional<CourseRoot> delete(UUID id);

}
