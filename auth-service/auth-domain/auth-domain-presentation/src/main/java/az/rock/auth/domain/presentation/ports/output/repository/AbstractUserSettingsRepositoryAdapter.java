package az.rock.auth.domain.presentation.ports.output.repository;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.UserID;

import java.util.UUID;

@OutputPort
public interface AbstractUserSettingsRepositoryAdapter extends AbstractRepositoryAdapter<UserSettingsRoot> {
    UserSettingsRoot findByUserId(UserID userId);

}
