package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractUserCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<UserRoot> {

}
