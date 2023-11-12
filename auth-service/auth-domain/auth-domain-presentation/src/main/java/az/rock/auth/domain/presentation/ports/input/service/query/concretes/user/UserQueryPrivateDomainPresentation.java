package az.rock.auth.domain.presentation.ports.input.service.query.concretes.user;

import az.rock.auth.domain.presentation.dto.response.user.MyUserProfileResponse;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNotificationMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserProfileQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.user.UserMyAccountResponse;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user.AbstractUserQueryDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.exception.user.MyUserProfileNotFoundException;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Service;

@Service
public class UserQueryPrivateDomainPresentation implements AbstractUserQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;
    private final AbstractUserProfileQueryRepositoryAdapter userProfileQueryRepositoryAdapter;

    private final AbstractNotificationMessagePublisher notificationMessagePublisher;


    public UserQueryPrivateDomainPresentation(AbstractSecurityContextHolder securityContextHolder,
                                              AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                              AbstractUserProfileQueryRepositoryAdapter userProfileQueryRepositoryAdapter,
                                              AbstractNotificationMessagePublisher notificationMessagePublisher) {
        this.securityContextHolder = securityContextHolder;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.userProfileQueryRepositoryAdapter = userProfileQueryRepositoryAdapter;
        this.notificationMessagePublisher = notificationMessagePublisher;
    }

    @Override
    public UserMyAccountResponse myAccount() {
        UserID currentUser = this.securityContextHolder.availableUser();
        var optionalUserRoot = this.userQueryRepositoryAdapter.findById(currentUser);
        if (optionalUserRoot.isPresent()) {
            UserRoot userRoot = optionalUserRoot.get();
            return UserMyAccountResponse.of(userRoot);
        }else throw new AuthDomainPresentationException("F0000000018");
    }

    @Override
    public MyUserProfileResponse myProfile() {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalUserProfile = this.userProfileQueryRepositoryAdapter.findMyProfile(currentUser.getAbsoluteID());
        if (optionalUserProfile.isPresent())
            return MyUserProfileResponse.of(optionalUserProfile.get());
        else throw new MyUserProfileNotFoundException();
    }
}
