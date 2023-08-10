package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserSettingsDomainService;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Language;

public class UserSettingsDomainService implements AbstractUserSettingsDomainService {

    @Override
    public UserSettingsRoot validateAmdChangeLanguage(UserID userID, UserSettingsRoot userSettingsRoot, Language language) {
        userSettingsRoot.setLanguage(language);
        return userSettingsRoot;
    }
}
