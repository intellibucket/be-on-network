package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.UUID;

public interface AbstractNetworkQueryDomainPresentation {

    List<UUID> queryMyNetworks();
}
