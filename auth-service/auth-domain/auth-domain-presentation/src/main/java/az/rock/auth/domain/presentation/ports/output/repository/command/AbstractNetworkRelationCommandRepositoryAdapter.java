package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;

import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractNetworkRelationCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<NetworkRelationRoot> {
}
