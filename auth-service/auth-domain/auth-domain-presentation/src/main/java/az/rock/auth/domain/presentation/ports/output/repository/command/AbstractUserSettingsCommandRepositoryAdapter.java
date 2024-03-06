package az.rock.auth.domain.presentation.ports.output.repository.command;

import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractUserSettingsCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<UserSettingsRoot> {
}
