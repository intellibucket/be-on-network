package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@InputPort
@Transactional(readOnly = true)
public interface AbstractNetworkQueryDomainPresentation {

    List<UUID> findMyNetworks();

    List<UUID> findInMyNetworkPendingRequests();

    List<UUID> findMyPendingRequests();



}
