package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractDetailCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.DetailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.DetailJPARepository;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import org.springframework.stereotype.Component;

@Component
public class DetailCommandRepositoryAdapter implements AbstractDetailCommandRepositoryAdapter {
    private final DetailJPARepository detailJPARepository;

    private final DetailDataAccessMapper detailDataAccessMapper;

    public DetailCommandRepositoryAdapter(DetailJPARepository detailJPARepository,
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
