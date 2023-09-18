package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractBlockRelationCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<BlockRelationRoot> {
}
