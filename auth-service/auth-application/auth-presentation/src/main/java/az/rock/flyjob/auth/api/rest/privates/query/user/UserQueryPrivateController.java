package az.rock.flyjob.auth.api.rest.privates.query.user;

import az.rock.auth.domain.presentation.dto.response.user.*;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user.AbstractUserQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.common.PageableRequest;
import az.rock.spec.auth.privates.query.UserQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get-any-profile/{userId}")
    public ResponseEntity<JSuccessDataResponse<AnyUserProfileResponse>> getAnyProfile(@PathVariable(name = "userId" ) UUID userId) {
        var response = this.userQueryDomainPresentation.anyProfile(userId);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @PostMapping("/get-user-list")
    public ResponseEntity<JSuccessDataResponse<List<SimpleAnyUserProfileResponse>>> getUserList(@RequestBody List<UUID> users) {
        List<SimpleAnyUserProfileResponse> response = this.userQueryDomainPresentation.anyProfiles(users);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @PostMapping("/get-my-follower-items")
    public ResponseEntity<JSuccessDataResponse<List<SimpleFollowerUserResponse>>> getMyFollowerItems(@RequestBody PageableRequest request) {
        List<SimpleFollowerUserResponse> response = this.userQueryDomainPresentation.myFollowerItems(request);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
    @Override
    @PostMapping("/get-my-networks-items")
    public ResponseEntity<JSuccessDataResponse<List<SimpleNetworkUserResponse>>> getMyNetworkItems(@RequestBody PageableRequest request) {
        List<SimpleNetworkUserResponse> response = this.userQueryDomainPresentation.myNetworkItems(request);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }


}
