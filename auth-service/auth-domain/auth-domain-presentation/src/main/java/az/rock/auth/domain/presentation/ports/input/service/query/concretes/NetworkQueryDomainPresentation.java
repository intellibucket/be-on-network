package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractNetworkQueryDomainPresentation;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NetworkQueryDomainPresentation implements AbstractNetworkQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;



    public NetworkQueryDomainPresentation(AbstractSecurityContextHolder securityContextHolder) {
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public List<UUID> queryMyNetworks() {
        return null;
    }
}
