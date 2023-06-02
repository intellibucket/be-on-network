package az.rock.spec.auth.privates.command;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

public interface PasswordCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> changePassword(PasswordChangeRequest passwordChangeRequest);
}
