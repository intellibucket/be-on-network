package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.PasswordCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/password",produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordCommandPrivateController implements PasswordCommandPrivateSpec {


    @Override
    @PutMapping("/change-password")
    public ResponseEntity<JSuccessResponse> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
        return null;
    }
}
