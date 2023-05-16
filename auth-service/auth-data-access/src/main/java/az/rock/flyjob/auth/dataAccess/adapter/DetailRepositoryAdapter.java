package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractDetailRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.DetailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.DetailJPARepository;
import az.rock.flyjob.auth.root.DetailRoot;
import org.springframework.stereotype.Component;

@Component
public class DetailRepositoryAdapter implements AbstractDetailRepositoryAdapter {
    private final DetailJPARepository detailJPARepository;

    private final DetailDataAccessMapper detailDataAccessMapper;

    public DetailRepositoryAdapter(DetailJPARepository detailJPARepository,
                                   DetailDataAccessMapper detailDataAccessMapper) {
        this.detailJPARepository = detailJPARepository;
        this.detailDataAccessMapper = detailDataAccessMapper;
    }

    @Override
    public DetailRoot create(DetailRoot root) {
        var entity = this.detailDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.detailJPARepository.save(entity);
        return this.detailDataAccessMapper.toRoot(savedEntity);
    }
}
