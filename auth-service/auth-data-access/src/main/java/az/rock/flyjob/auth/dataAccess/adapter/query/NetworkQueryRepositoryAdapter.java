package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractNetworkDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.NetworkQueryJPARepository;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<NetworkRelationRoot> findNetworkRelationByBothOfUserIDs(UserID firstUserID, UserID secondUserID) {
        var networkRelationEntityOptional = Optional.ofNullable(
                this.networkQueryJPARepository
                .findNetworkRelationByBothOfUserIDs(firstUserID.getAbsoluteID(), secondUserID.getAbsoluteID())
        );
        if (networkRelationEntityOptional.isPresent())
            return this.networkDataAccessMapper.toRoot(networkRelationEntityOptional.get());
        return Optional.empty();
    }

    @Override
    public List<NetworkRelationRoot> findMyNetworks(UserID currentUserID) {
        return this.networkQueryJPARepository.findMyNetworks(currentUserID.getAbsoluteID())
                .stream().map(this.networkDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<NetworkRelationRoot> findInMyNetworkPendingRequests(UserID currentUserID) {
        return this.networkQueryJPARepository.findInMyNetworkPendingRequests(currentUserID.getAbsoluteID())
                .stream().map(this.networkDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<NetworkRelationRoot> findMyPendingRequests(UserID currentUserID) {
        return this.networkQueryJPARepository.findMyNetworkPendingRequests(currentUserID.getAbsoluteID())
                .stream().map(this.networkDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
