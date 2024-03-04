package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;

import java.util.Optional;
import java.util.UUID;

public class CourseCommandRepositoryAdapter implements AbstractCourseCommandRepositoryAdapter {
    @Override
    public Optional<CourseRoot> create(CourseRoot root) {
        return Optional.empty();
    }

    @Override
    public Optional<CourseRoot> update(CourseRoot root) {
        return Optional.empty();
    }

    @Override
    public Optional<CourseRoot> delete(UUID id) {
        return Optional.empty();
    }
}
