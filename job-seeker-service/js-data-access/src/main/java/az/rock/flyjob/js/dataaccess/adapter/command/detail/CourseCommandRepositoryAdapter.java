package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.CustomCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractCourseCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractResumeCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail.CourseCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CourseCommandRepositoryAdapter implements AbstractCourseCommandRepositoryAdapter {

    private final AbstractCourseDataAccessMapper abstractCourseDataAccessMapper;

    private final AbstractCourseCommandJPARepository repository;

    private final CourseCustomCommandJPARepository customCommandJPARepository;


    public CourseCommandRepositoryAdapter(AbstractCourseDataAccessMapper abstractCourseDataAccessMapper, AbstractCourseCommandJPARepository repository, CourseCustomCommandJPARepository customCommandJPARepository) {
        this.abstractCourseDataAccessMapper = abstractCourseDataAccessMapper;
        this.repository = repository;
        this.customCommandJPARepository = customCommandJPARepository;
    }

    //TODO bunu sorus
    @Override
    public Optional<CourseRoot> create(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return Optional.empty();
        var courseEntity = optional.get();
        return this.abstractCourseDataAccessMapper.toRoot(
                customCommandJPARepository.persist(courseEntity)
        );
    }
    @Override
    public void update(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return;
        var courseEntity = optional.get();
        customCommandJPARepository.merge(courseEntity);
    }

    @Override
    public void inActive(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return;
        optional.get().inActive();
        this.repository.save(optional.get());

    }

    @Override
    public Optional<CourseRoot> updateCertificatePath(UUID id,String newFilePath) {
        return this.abstractCourseDataAccessMapper.toRoot(this.repository.setCourseCertificatePath(id,newFilePath));
    }

}
