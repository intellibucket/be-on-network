package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.Language;

public interface AbstractUserSettingsDomainService {
    UserSettingsRoot validateAmdChangeLanguage(UserID userID, UserSettingsRoot userSettingsRoot, Language language);
}
