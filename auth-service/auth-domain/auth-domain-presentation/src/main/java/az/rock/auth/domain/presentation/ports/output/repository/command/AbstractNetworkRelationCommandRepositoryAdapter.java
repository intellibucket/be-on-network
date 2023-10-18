package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractNetworkRelationCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<NetworkRelationRoot> {
}
