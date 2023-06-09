package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractNetworkDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.NetworkQueryJPARepository;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class NetworkQueryRepositoryAdapter implements AbstractNetworkQueryRepositoryAdapter {

    private final NetworkQueryJPARepository networkQueryJPARepository;

    private final AbstractNetworkDataAccessMapper<NetworkRelationEntity,NetworkRelationRoot> networkDataAccessMapper;

    public NetworkQueryRepositoryAdapter(NetworkQueryJPARepository networkQueryJPARepository,
                                         AbstractNetworkDataAccessMapper<NetworkRelationEntity,NetworkRelationRoot> networkDataAccessMapper) {
        this.networkQueryJPARepository = networkQueryJPARepository;
        this.networkDataAccessMapper = networkDataAccessMapper;
    }

    @Override
    public List<UUID> findMyNetworks(UserID currentUserID) {
        return this.networkQueryJPARepository.findMyNetworks(currentUserID.getAbsoluteID())
                .stream().map(this.networkDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(NetworkRelationRoot::isAcceptedStatus)
                .filter(NetworkRelationRoot::isNonBlockedStatus)
                .map(root->root.getOtherPair(currentUserID.getAbsoluteID()))
                .toList();
    }

    @Override
    public List<UUID> findInMyNetworkPendingRequests(UserID currentUserID) {
        return null;
    }

    @Override
    public List<UUID> findMyPendingRequests(UserID currentUserID) {
        return null;
    }
}
