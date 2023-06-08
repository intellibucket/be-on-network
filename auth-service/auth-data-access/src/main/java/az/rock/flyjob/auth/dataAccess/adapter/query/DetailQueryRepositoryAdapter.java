package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractDetailQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.DetailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.DetailQueryJPARepository;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailQueryRepositoryAdapter implements AbstractDetailQueryRepositoryAdapter {
    private final DetailQueryJPARepository detailQueryJPARepository;
    private final DetailDataAccessMapper detailDataAccessMapper;

    public DetailQueryRepositoryAdapter(DetailQueryJPARepository detailQueryJPARepository,
                                        DetailDataAccessMapper detailDataAccessMapper) {
        this.detailQueryJPARepository = detailQueryJPARepository;
        this.detailDataAccessMapper = detailDataAccessMapper;
    }

    @Override
    public Optional<DetailRoot> findById(DetailID rootId) {
        var entity = this.detailQueryJPARepository.findById(rootId.getAbsoluteID());
        return this.detailDataAccessMapper.toRoot(entity.orElse(null));
    }

    @Override
    public Optional<DetailRoot> findByPID(UserID parentID) {
        return null;
    }

    @Override
    public Optional<DetailRoot> findByPIDAndActiveStatus(UserID parentID) {
        return null;
    }

    @Override
    public Optional<DetailRoot> findByIdAndActiveStatus(DetailID detailID) {
        return null;
    }
}
