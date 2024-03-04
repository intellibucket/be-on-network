package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractCourseCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.lib.valueObject.common.PageableRequest;

import java.util.Optional;
import java.util.UUID;

public class CourseCommandRepositoryAdapter implements AbstractCourseCommandRepositoryAdapter {

    private final AbstractCourseDataAccessMapper abstractCourseDataAccessMapper;

    private final AbstractCourseCommandJPARepository repository;

    public CourseCommandRepositoryAdapter(AbstractCourseDataAccessMapper abstractCourseDataAccessMapper, AbstractCourseCommandJPARepository repository) {
        this.abstractCourseDataAccessMapper = abstractCourseDataAccessMapper;
        this.repository = repository;
    }

    @Override
    public Optional<CourseRoot> create(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        return this.abstractCourseDataAccessMapper.toRoot(
                repository.saveAndFlush(optional.orElseThrow(()->new RuntimeException("")))
        );
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
