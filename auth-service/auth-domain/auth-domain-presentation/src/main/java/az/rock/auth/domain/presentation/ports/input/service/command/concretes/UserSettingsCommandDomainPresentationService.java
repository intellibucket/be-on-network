package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserSettingsUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserSettingsCommandDomainPresentationService;
import az.rock.lib.event.impl.concretes.auth.update.UserSettingsUpdatedEvent;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsCommandDomainPresentationService implements AbstractUserSettingsCommandDomainPresentationService {

    private final AbstractUserSettingsUpdateCommandHandler userSettingsUpdateCommandHandler;

    public UserSettingsCommandDomainPresentationService(AbstractUserSettingsUpdateCommandHandler userSettingsUpdateCommandHandler) {
        this.userSettingsUpdateCommandHandler = userSettingsUpdateCommandHandler;
    }

    @Override
    public void changeLanguage(Language language) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleLanguageChange(language);
    }

    @Override
    public void changeDarkMode(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeDarkMode(switcher);
    }

    @Override
    public void changeEmailNotification(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeEmailNotification(switcher);
    }

    @Override
    public void changeSmsNotification(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeSmsNotification(switcher);
    }

    @Override
    public void changePushNotification(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangePushNotification(switcher);
    }

    @Override
    public void changeTwoFactorAuthentication(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeTwoFactorAuthentication(switcher);
    }

    @Override
    public void changeVisibleLocation(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleLocation(switcher);
    }

    @Override
    public void changeVisibleOnlineStatus(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleOnlineStatus(switcher);
    }

    @Override
    public void changeVisibleLastSeen(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleLastSeen(switcher);
    }

    @Override
    public void changeVisibleProfilePicture(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleProfilePicture(switcher);
    }

    @Override
    public void changeVisibleEmail(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleEmail(switcher);
    }

    @Override
    public void changeVisibleResume(Switch switcher) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleChangeVisibleResume(switcher);
    }
}
