package az.rock.flyjob.auth.api.rest.privates.query.user;

import az.rock.auth.domain.presentation.dto.response.UserAnyAccountResponse;
import az.rock.auth.domain.presentation.dto.response.user.MyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleFollowerUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleNetworkUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.UserMyAccountResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user.AbstractUserQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageable;
import az.rock.lib.valueObject.common.PageableRequest;
import az.rock.spec.auth.privates.query.UserQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserQueryPrivateController implements UserQueryPrivateSpec {

    private final AbstractUserQueryDomainPresentation userQueryDomainPresentation;

    public UserQueryPrivateController(AbstractUserQueryDomainPresentation userQueryDomainPresentation) {
        this.userQueryDomainPresentation = userQueryDomainPresentation;
    }


    @Override
    @GetMapping("/get-my-profile")
    public ResponseEntity<JSuccessDataResponse<MyUserProfileResponse>> getMyProfile() {
        var response = this.userQueryDomainPresentation.myProfile();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-user")
    public ResponseEntity<JSuccessDataResponse<UserAnyAccountResponse>> getUser(UUID userId) {
        return null;
    }

    @Override
    @GetMapping("/get-user-list")
    public ResponseEntity<JSuccessDataResponse<List<UserAnyAccountResponse>>> getUserList(List<UUID> users) {
        return null;
    }

    @Override
    @GetMapping("/get-my-follower-items")
    public ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleFollowerUserResponse>>>> getMyFollowerItems(PageableRequest request) {
        return null;
    }

    @Override
    @GetMapping("/get-my-networks-items")
    public ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleNetworkUserResponse>>>> getMyNetworkItems(PageableRequest request) {
        return null;
    }


}
