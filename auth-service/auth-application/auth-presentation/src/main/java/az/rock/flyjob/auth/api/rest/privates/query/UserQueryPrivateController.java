package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserAnyAccountResponse;
import az.rock.auth.domain.presentation.dto.response.UserMyAccountResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractUserQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
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
    @GetMapping("/get-current-user")
    public ResponseEntity<JSuccessDataResponse<UserMyAccountResponse>> getCurrentUser() {
        var response = this.userQueryDomainPresentation.myAccount();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<UserAnyAccountResponse>> getUser(UUID userId) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<UserAnyAccountResponse>>> getUserList(List<UUID> users) {
        return null;
    }


}
