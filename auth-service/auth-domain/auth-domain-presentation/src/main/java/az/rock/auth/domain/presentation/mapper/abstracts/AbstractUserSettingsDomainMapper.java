package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractUserSettingsDomainMapper {
    UserSettingsRoot defaultUserSettingsRoot(UserID userID);


}
