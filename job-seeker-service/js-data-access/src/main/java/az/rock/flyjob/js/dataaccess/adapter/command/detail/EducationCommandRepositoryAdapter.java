package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractEducationCommandJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class EducationCommandRepositoryAdapter implements AbstractEducationCommandRepositoryAdapter {
    private final AbstractEducationDataAccessMapper educationDataAccessMapper;
    private final AbstractEducationCommandJpaRepository educationCommandJpaRepository;

    public EducationCommandRepositoryAdapter(AbstractEducationDataAccessMapper educationDataAccessMapper, AbstractEducationCommandJpaRepository educationCommandJpaRepository) {
        this.educationDataAccessMapper = educationDataAccessMapper;
        this.educationCommandJpaRepository = educationCommandJpaRepository;

    }


    public Optional<EducationRoot> create(EducationRoot root) {
        var optionalEntity = this.educationDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var savedEntity = this.educationCommandJpaRepository.save(optionalEntity.get());
        }
        return Optional.empty();
    }

    @Override
    public void update(EducationRoot root) {
        AbstractEducationCommandRepositoryAdapter.super.update(root);
    }

    @Override
    public void updateAll(List<EducationRoot> emailRoots) {
        AbstractEducationCommandRepositoryAdapter.super.updateAll(emailRoots);
    }

    @Override
    public void inActive(EducationRoot root) {
        AbstractEducationCommandRepositoryAdapter.super.inActive(root);
    }

    @Override
    public void rollback(EducationRoot root) {
        AbstractEducationCommandRepositoryAdapter.super.rollback(root);
    }
}
