package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractNetworkRelationCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractNetworkRelationCommandJPARepository;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NetworkCommandRepositoryAdapter implements AbstractNetworkRelationCommandRepositoryAdapter {

    private final AbstractNetworkRelationCommandJPARepository networkRelationCommandJPARepository;

    private final AbstractDataAccessMapper<NetworkRelationEntity, NetworkRelationRoot> networkRelationDataAccessMapper;


    public NetworkCommandRepositoryAdapter(AbstractNetworkRelationCommandJPARepository networkRelationCommandJPARepository,
                                           AbstractDataAccessMapper<NetworkRelationEntity, NetworkRelationRoot> networkRelationDataAccessMapper) {
        this.networkRelationCommandJPARepository = networkRelationCommandJPARepository;
        this.networkRelationDataAccessMapper = networkRelationDataAccessMapper;
    }

    @Override
    public Optional<NetworkRelationRoot> create(NetworkRelationRoot root) {
        var entity = this.networkRelationDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.networkRelationCommandJPARepository.persist(entity.get());
            return this.networkRelationDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(NetworkRelationRoot root) {
        var entity = this.networkRelationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.networkRelationCommandJPARepository::update);
    }

    @Override
    public void delete(NetworkRelationRoot root) {
        var entity = this.networkRelationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.networkRelationCommandJPARepository::inActive);
    }
}
