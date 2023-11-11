package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractNetworkQueryDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NetworkQueryDomainPresentation implements AbstractNetworkQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter;


    public NetworkQueryDomainPresentation(AbstractSecurityContextHolder securityContextHolder,
                                          AbstractNetworkQueryRepositoryAdapter networkQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.networkQueryRepositoryAdapter = networkQueryRepositoryAdapter;
    }

    @Override
    public List<UUID> findMyNetworks() {
        var currentUserID = this.securityContextHolder.availableUser();
        return this.networkQueryRepositoryAdapter.findMyNetworks(currentUserID)
                        .stream()
                        .filter(NetworkRelationRoot::hasNetwork)
                        .map(root->root.getOtherPair(currentUserID.getAbsoluteID()))
                        .toList();
    }

    @Override
    public List<UUID> findInMyNetworkPendingRequests() {
        var currentUserID = this.securityContextHolder.availableUser();
        return this.networkQueryRepositoryAdapter.findInMyNetworkPendingRequests(currentUserID)
                .stream()
                .filter(NetworkRelationRoot::isAvailableForAccept)
                .map(root->root.getOtherPair(currentUserID.getAbsoluteID()))
                .toList();
    }

    @Override
    public List<UUID> findMyPendingRequests() {
        var currentUserID = this.securityContextHolder.availableUser();
        return this.networkQueryRepositoryAdapter.findMyPendingRequests(currentUserID)
                .stream()
                .filter(NetworkRelationRoot::isAvailableForAccept)
                .map(root->root.getOtherPair(currentUserID.getAbsoluteID()))
                .toList();
    }

}
