package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractBlockRelationCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<BlockRelationRoot> {
}
