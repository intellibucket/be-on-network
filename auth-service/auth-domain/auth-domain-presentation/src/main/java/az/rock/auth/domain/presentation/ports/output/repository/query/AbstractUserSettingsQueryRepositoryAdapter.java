package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.domain.id.UserSettingsID;

@OutputPort
public interface AbstractUserSettingsQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<UserSettingsRoot, UserSettingsID,UserID> {

}
