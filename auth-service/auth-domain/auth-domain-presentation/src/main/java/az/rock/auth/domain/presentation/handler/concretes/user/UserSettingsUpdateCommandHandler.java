package az.rock.auth.domain.presentation.handler.concretes.user;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.UnknownSystemException;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserSettingsUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserSettingsCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.user.UserSettingsUpdatedEvent;
import az.rock.flyjob.auth.service.abstracts.AbstractUserSettingsDomainService;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsUpdateCommandHandler implements AbstractUserSettingsUpdateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractUserSettingsQueryRepositoryAdapter userSettingsQueryRepositoryAdapter;
    private final AbstractUserSettingsCommandRepositoryAdapter userSettingsCommandRepositoryAdapter;

    private final AbstractUserSettingsDomainService userSettingsDomainService;
    public UserSettingsUpdateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                            AbstractUserSettingsQueryRepositoryAdapter userSettingsQueryRepositoryAdapter,
                                            AbstractUserSettingsCommandRepositoryAdapter userSettingsCommandRepositoryAdapter,
                                            AbstractUserSettingsDomainService userSettingsDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.userSettingsQueryRepositoryAdapter = userSettingsQueryRepositoryAdapter;
        this.userSettingsCommandRepositoryAdapter = userSettingsCommandRepositoryAdapter;
        this.userSettingsDomainService = userSettingsDomainService;
    }

    @Override
    public UserSettingsUpdatedEvent handleLanguageChange(Language language) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalEntity = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalEntity.isPresent()){
            var entity = optionalEntity.get();
            var changedEntity  = this.userSettingsDomainService.validateAmdChangeLanguage(currentUserID,entity,language);
            this.userSettingsCommandRepositoryAdapter.update(changedEntity);
            return UserSettingsUpdatedEvent.of(changedEntity);
        }else throw new UnknownSystemException();
    }

    // TODO: 29.06.23 must be implement other methods
    @Override
    public UserSettingsUpdatedEvent handleChangeDarkMode(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeEmailNotification(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeSmsNotification(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangePushNotification(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeTwoFactorAuthentication(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleLocation(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleOnlineStatus(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleLastSeen(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleProfilePicture(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleEmail(Switch switcher) {
        return null;
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleResume(Switch switcher) {
        return null;
    }
}
