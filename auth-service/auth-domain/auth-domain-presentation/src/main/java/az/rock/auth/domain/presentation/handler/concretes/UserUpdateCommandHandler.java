package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.UserUpdatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
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
        var currentUserID = this.securityContextHolder.currentUser();
        var currentUserRoot = this.userQueryRepositoryAdapter.findById(currentUserID);
        if (currentUserRoot.isEmpty()) throw new AuthDomainException("F0000000018");
        return currentUserRoot.get();
    }

//    private final BiFunction<String, BiFunction<UserRoot,String,UserRoot>,UserUpdatedEvent> handle = (value, function) -> {
//        var currentUserRoot = this.findCurrentUser();
//        var updatedRoot = function.apply(currentUserRoot, value);
//        return UserUpdatedEvent.of(updatedRoot);
//    };

    @Override
    public UserUpdatedEvent handleFirstnameUpdated(String firstname) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeFirstName(currentUserRoot, firstname);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return UserUpdatedEvent.of(updatedRoot);
    }

    @Override
    public UserUpdatedEvent handleLastnameUpdated(String lastname) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeLastName(currentUserRoot, lastname);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return UserUpdatedEvent.of(updatedRoot);
    }

    @Override
    public UserUpdatedEvent handleUsernameUpdated(String username) {
        var currentUserRoot = this.findCurrentUser();
        var isExist = this.userQueryRepositoryAdapter.isExistByUsername(username);
        if (isExist) throw new AuthDomainException("F0000000028");
        var updatedRoot = this.userDomainService.changeUsername(currentUserRoot, username);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return UserUpdatedEvent.of(updatedRoot);
    }

    @Override
    public UserUpdatedEvent handleGenderUpdated(Gender gender) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeGender(currentUserRoot, gender);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return UserUpdatedEvent.of(updatedRoot);
    }

    @Override
    public UserUpdatedEvent handleTimezoneUpdated(TimeZoneID timezone) {
        var currentUserRoot = this.findCurrentUser();
        var updatedRoot = this.userDomainService.changeTimezone(currentUserRoot, timezone);
        this.userCommandRepositoryAdapter.update(updatedRoot);
        return UserUpdatedEvent.of(updatedRoot);
    }
}
