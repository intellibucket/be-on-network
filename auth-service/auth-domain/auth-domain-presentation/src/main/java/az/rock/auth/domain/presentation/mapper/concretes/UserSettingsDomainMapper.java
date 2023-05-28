package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserSettingsDomainMapper;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsDomainMapper implements AbstractUserSettingsDomainMapper {
    public UserSettingsRoot defaultUserSettingsRoot(UserID userID) {
        return null;
    }
}
