package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCustomEducationCommandJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import az.rock.lib.jexception.NoActiveRowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class EducationCommandRepositoryAdapter implements AbstractEducationCommandRepositoryAdapter {
    private final AbstractEducationDataAccessMapper educationDataAccessMapper;
    private final AbstractCustomEducationCommandJpaRepository educationCustomCommandJpaRepository;
    private final AbstractCustomEducationQueryJpaRepository educationQueryJpaRepository;

    public EducationCommandRepositoryAdapter(AbstractEducationDataAccessMapper educationDataAccessMapper, AbstractCustomEducationCommandJpaRepository educationCustomCommandJpaRepository) {
        this.educationDataAccessMapper = educationDataAccessMapper;
        this.educationCustomCommandJpaRepository = educationCustomCommandJpaRepository;

    }


    public Optional<EducationRoot> create(EducationRoot root) {
        var optionalEntity = this.educationDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var savedEntity = educationCustomCommandJpaRepository.persist(optionalEntity.get());
            return this.educationDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(EducationRoot root) {
        var entityFromDatabase = educationCustomCommandJpaRepository.
        (ResumeEntity.referenceOf
                (root.getResumeID().getAbsoluteID()),
                root.getRootID().getAbsoluteID()).orElseThrow(NoActiveRowException::new);
        var updatedEntity = educationDataAccessMapper.setRootToExistEntity(entityFromDatabase, root);
        educationCustomCommandJpaRepository.save(updatedEntity.get());

    }

    @Override
    public void updateAll(List<EducationRoot> emailRoots) {
        AbstractEducationCommandRepositoryAdapter.super.updateAll(emailRoots);
    }

    @Override
    public void inActive(EducationRoot root) {
        var optionalEntity = this.educationDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            optionalEntity.get().inActive();
            educationCustomCommandJpaRepository.persist(optionalEntity.get());
        }
    }

    @Override
    public void rollback(EducationRoot root) {
        AbstractEducationCommandRepositoryAdapter.super.rollback(root);
    }


}

