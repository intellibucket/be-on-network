package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;

import java.util.Optional;
import java.util.UUID;


public interface AbstractCourseCommandRepositoryAdapter {
    Optional<CourseRoot> merge(CourseRoot root);
    Optional<CourseRoot> delete(UUID id);

}
