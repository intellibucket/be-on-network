package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;

public interface AbstractUserSettingsDomainMapper {
    UserSettingsRoot defaultUserSettingsRoot(UserID userID);


}
