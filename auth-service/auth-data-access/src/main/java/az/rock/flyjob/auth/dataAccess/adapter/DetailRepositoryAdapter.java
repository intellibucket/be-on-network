package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractDetailRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.AccountDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.detail.DetailJPARepository;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import org.springframework.stereotype.Component;

@Component
public class DetailRepositoryAdapter implements AbstractDetailRepositoryAdapter {
    private final DetailJPARepository detailJPARepository;

    private final AccountDataAccessMapper accountDataAccessMapper;

    public DetailRepositoryAdapter(DetailJPARepository detailJPARepository,
                                   AccountDataAccessMapper accountDataAccessMapper) {
        this.detailJPARepository = detailJPARepository;
        this.accountDataAccessMapper = accountDataAccessMapper;
    }

    @Override
    public DetailRoot create(DetailRoot root) {
        var entity = this.accountDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.detailJPARepository.save(entity);
        return this.accountDataAccessMapper.toRoot(savedEntity);
    }
}
