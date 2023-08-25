package az.rock.auth.domain.presentation.handler.abstracts.user;

import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import com.intellibukcet.lib.payload.event.update.settings.UserSettingsUpdatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserSettingsUpdateCommandHandler {
    UserSettingsUpdatedEvent handleLanguageChange(Language language);

    UserSettingsUpdatedEvent handleChangeDarkMode(Switch switcher);

    UserSettingsUpdatedEvent handleChangeEmailNotification(Switch switcher);

    UserSettingsUpdatedEvent handleChangeSmsNotification(Switch switcher);

    UserSettingsUpdatedEvent handleChangePushNotification(Switch switcher);

    UserSettingsUpdatedEvent handleChangeTwoFactorAuthentication(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleLocation(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleOnlineStatus(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleLastSeen(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleProfilePicture(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleEmail(Switch switcher);

    UserSettingsUpdatedEvent handleChangeVisibleResume(Switch switcher);
}
