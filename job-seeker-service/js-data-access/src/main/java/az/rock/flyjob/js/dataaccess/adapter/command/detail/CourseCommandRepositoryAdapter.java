package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractCourseCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractResumeCommandJPARepository;
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

    private final AbstractResumeCommandJPARepository resumeCommandJPARepository;

    public CourseCommandRepositoryAdapter(AbstractCourseDataAccessMapper abstractCourseDataAccessMapper, AbstractCourseCommandJPARepository repository, AbstractResumeCommandJPARepository resumeCommandJPARepository) {
        this.abstractCourseDataAccessMapper = abstractCourseDataAccessMapper;
        this.repository = repository;
        this.resumeCommandJPARepository = resumeCommandJPARepository;
    }


    //TODO bunu sorus
    @Override
    public Optional<CourseRoot> merge(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return Optional.empty();
        var courseEntity = optional.get();
        var resume = resumeCommandJPARepository.findById(root.getResume().getAbsoluteID());
        if(resume.isEmpty())return Optional.empty();
        courseEntity.setResume(
                resume.get()
        );
        return this.abstractCourseDataAccessMapper.toRoot(
                repository.saveAndFlush(courseEntity)
        );
    }

    @Override
    public Optional<CourseRoot> delete(UUID id) {
        return this.abstractCourseDataAccessMapper.toRoot(this.repository.setRowStatusById(id,RowStatus.DELETED));
    }

    @Override
    public Optional<CourseRoot> updateCertificatePath(UUID id,String newFilePath) {
        return this.abstractCourseDataAccessMapper.toRoot(this.repository.setCourseCertificatePath(id,newFilePath));
    }

}
