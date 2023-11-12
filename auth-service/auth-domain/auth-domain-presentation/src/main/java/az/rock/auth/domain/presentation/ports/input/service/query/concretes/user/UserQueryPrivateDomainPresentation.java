package az.rock.auth.domain.presentation.ports.input.service.query.concretes.user;

import az.rock.auth.domain.presentation.dto.response.user.*;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractNotificationMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserProfileQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user.AbstractUserQueryDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.exception.user.MyUserProfileNotFoundException;
import az.rock.flyjob.auth.exception.user.UserProfileNotFoundException;
import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.common.PageableRequest;
import com.intellibucket.lib.fj.notificatin.api.notifications.ViewedProfileNotification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public MyUserProfileResponse myProfile() {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalUserProfile = this.userProfileQueryRepositoryAdapter.findMyProfile(currentUser.getAbsoluteID());
        if (optionalUserProfile.isPresent())
            return MyUserProfileResponse.of(optionalUserProfile.get());
        else throw new MyUserProfileNotFoundException();
    }

    @Override
    public AnyUserProfileResponse anyProfile(UUID userID) {
        var currentUser = this.securityContextHolder.availableUser();
        Optional<AnyProfileQueryRecord> optionalUserProfile = this.userProfileQueryRepositoryAdapter.findAnyProfile(currentUser.getAbsoluteID(), userID);
        if (optionalUserProfile.isPresent()){
            this.notificationMessagePublisher.send(ViewedProfileNotification.of(currentUser.getAbsoluteID(), userID));
            return AnyUserProfileResponse.of(optionalUserProfile.get());
        }
        else throw new UserProfileNotFoundException();
    }

    @Override
    public List<SimpleAnyUserProfileResponse> anyProfiles(List<UUID> userIDs) {
        return null;
    }

    @Override
    public List<SimpleFollowerUserResponse> myFollowerItems(PageableRequest request) {
        return null;
    }

    @Override
    public List<SimpleNetworkUserResponse> myNetworkItems(PageableRequest request) {
        return null;
    }
}
