package az.rock.auth.domain.presentation.handler.concretes.user;

import az.rock.auth.domain.presentation.exception.UnknownSystemException;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserSettingsUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserSettingsCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserSettingsDomainService;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import com.intellibucket.lib.payload.event.update.settings.UserSettingsUpdatedEvent;
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
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeDarkMode(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeDarkMode(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeEmailNotification(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeEmailNotification(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeSmsNotification(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeSmsNotification(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangePushNotification(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangePushNotification(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeTwoFactorAuthentication(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeTwoFactorAuthentication(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleLocation(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleLocation(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleOnlineStatus(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleOnlineStatus(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleLastSeen(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleLastSeen(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleProfilePicture(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()) {
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleProfilePicture(currentUserID, root, switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleEmail(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalRoot.isPresent()){
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleEmail(currentUserID,root,switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }

    @Override
    public UserSettingsUpdatedEvent handleChangeVisibleResume(Switch switcher) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserID);
        if(optionalRoot.isPresent()){
            var root = optionalRoot.get();
            UserSettingsRoot changedRoot =
                    this.userSettingsDomainService.validateAndChangeVisibleResume(currentUserID,root,switcher);
            this.userSettingsCommandRepositoryAdapter.update(changedRoot);
            return null;
        }else throw new UnknownSystemException();
    }
}
