package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractPasswordCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.PasswordCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/password",produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordCommandPrivateController implements PasswordCommandPrivateSpec {
    private final AbstractPasswordCommandDomainPresentationService passwordCommandDomainPresentationService;

    public PasswordCommandPrivateController(AbstractPasswordCommandDomainPresentationService passwordCommandDomainPresentationService) {
        this.passwordCommandDomainPresentationService = passwordCommandDomainPresentationService;
    }

    @Override
    @PutMapping("/change-password")
    public ResponseEntity<JSuccessResponse> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
        this.passwordCommandDomainPresentationService.changePassword(passwordChangeRequest);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
