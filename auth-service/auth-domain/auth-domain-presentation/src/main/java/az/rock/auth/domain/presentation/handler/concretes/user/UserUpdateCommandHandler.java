package az.rock.auth.domain.presentation.handler.concretes.user;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibukcet.lib.payload.event.update.user.UserUpdatedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateCommandHandler  implements AbstractUserUpdateCommandHandler {


    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;

    private final AbstractUserDomainService userDomainService;

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractUserCommandRepositoryAdapter userCommandRepositoryAdapter;

    public UserUpdateCommandHandler(AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                    AbstractUserDomainService userDomainService,
                                    AbstractSecurityContextHolder securityContextHolder,
                                    AbstractUserCommandRepositoryAdapter userCommandRepositoryAdapter) {
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.userDomainService = userDomainService;
        this.securityContextHolder = securityContextHolder;
        this.userCommandRepositoryAdapter = userCommandRepositoryAdapter;
    }

    private UserRoot findCurrentUser(){
        var currentUserID = this.securityContextHolder.availableUser();
        var currentUserRoot = this.userQueryRepositoryAdapter.findById(currentUserID);
        if (currentUserRoot.isEmpty()) throw new AuthDomainPresentationException("F0000000018");
        return currentUserRoot.get();
    }


    @Override
    public UserUpdatedEvent handleFirstnameUpdated(String firstname) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeFirstName(currentUserRoot, firstname);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return null;
    }

    @Override
    public UserUpdatedEvent handleLastnameUpdated(String lastname) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeLastName(currentUserRoot, lastname);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return null;
    }

    @Override
    public UserUpdatedEvent handleUsernameUpdated(String username) {
        var currentUserRoot = this.findCurrentUser();
        var isExist = this.userQueryRepositoryAdapter.isExistByUsername(username);
        if (isExist) throw new AuthDomainPresentationException("F0000000028");
        var updatedRoot = this.userDomainService.changeUsername(currentUserRoot, username);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return null;
    }

    @Override
    public UserUpdatedEvent handleGenderUpdated(Gender gender) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeGender(currentUserRoot, gender);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return null;
    }

    @Override
    public UserUpdatedEvent handleTimezoneUpdated(TimeZoneID timezone) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeTimezone(currentUserRoot, timezone);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return null;
    }
}
