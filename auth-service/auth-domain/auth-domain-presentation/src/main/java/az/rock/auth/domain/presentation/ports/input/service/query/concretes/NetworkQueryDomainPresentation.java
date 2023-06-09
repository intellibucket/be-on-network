package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractNetworkQueryDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
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
        var currentUserID = this.securityContextHolder.currentUser();
        return null;
    }

    @Override
    public List<UUID> findInMyNetworkPendingRequests() {
        var currentUserID = this.securityContextHolder.currentUser();
        return null;
    }

    @Override
    public List<UUID> findMyPendingRequests() {
        var currentUserID = this.securityContextHolder.currentUser();
        return null;
    }
}
