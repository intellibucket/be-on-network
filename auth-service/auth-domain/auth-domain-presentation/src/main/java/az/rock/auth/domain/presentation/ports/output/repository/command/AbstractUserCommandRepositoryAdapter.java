package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractUserCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<UserRoot> {

}
