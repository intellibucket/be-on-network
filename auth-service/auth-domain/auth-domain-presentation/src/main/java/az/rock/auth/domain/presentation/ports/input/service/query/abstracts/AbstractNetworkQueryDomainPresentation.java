package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import java.util.List;
import java.util.UUID;

public interface AbstractNetworkQueryDomainPresentation {

    List<UUID> findMyNetworks();

    List<UUID> findInMyNetworkPendingRequests();

    List<UUID> findMyPendingRequests();
}
