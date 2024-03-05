package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractCourseCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CourseCommandRepositoryAdapter implements AbstractCourseCommandRepositoryAdapter {

    private final AbstractCourseDataAccessMapper abstractCourseDataAccessMapper;

    private final AbstractCourseCommandJPARepository repository;

    public CourseCommandRepositoryAdapter(AbstractCourseDataAccessMapper abstractCourseDataAccessMapper, AbstractCourseCommandJPARepository repository) {
        this.abstractCourseDataAccessMapper = abstractCourseDataAccessMapper;
        this.repository = repository;
    }

    @Override
    public Optional<CourseRoot> merge(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return Optional.empty();
        else return this.abstractCourseDataAccessMapper.toRoot(
                repository.saveAndFlush(optional.get())
        );
    }

    @Override
    public Optional<CourseRoot> delete(UUID id) {
        return this.abstractCourseDataAccessMapper.toRoot(this.repository.setRowStatusById(id,RowStatus.DELETED));
    }
}
