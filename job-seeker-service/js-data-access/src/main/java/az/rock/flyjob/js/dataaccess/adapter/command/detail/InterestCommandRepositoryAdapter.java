package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractInterestCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.mapper.concretes.InterestDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractInterestCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class InterestCommandRepositoryAdapter implements AbstractInterestCommandRepositoryAdapter {

    private final AbstractInterestCustomCommandJPARepository interestCustomCommandJPARepository;
    private final AbstractInterestDataAccessMapper<InterestEntity, InterestRoot> interestDataAccessMapper;

    public InterestCommandRepositoryAdapter(AbstractInterestCustomCommandJPARepository interestCustomCommandJPARepository, AbstractInterestDataAccessMapper<InterestEntity, InterestRoot> interestDataAccessMapper) {
        this.interestCustomCommandJPARepository = interestCustomCommandJPARepository;
        this.interestDataAccessMapper = interestDataAccessMapper;
    }

    @Override
    public void inActive(InterestRoot root) {
        var entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::delete);

    }

    @Override
    public Optional<InterestRoot> create(InterestRoot root) {
        return Optional.empty();
    }

    @Override
    public void update(InterestRoot root) {
        var entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::merge);
    }


    @Override
    public void rollback(Collection<InterestRoot> roots) {
        AbstractInterestCommandRepositoryAdapter.super.rollback(roots);
    }

    @Override
    public void rollback(InterestRoot root) {
        AbstractInterestCommandRepositoryAdapter.super.rollback(root);
    }
}
