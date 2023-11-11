package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.auth.UserSettingsID;

@DomainOutputPort
public interface AbstractUserSettingsQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<UserSettingsRoot, UserSettingsID,UserID> {

}
