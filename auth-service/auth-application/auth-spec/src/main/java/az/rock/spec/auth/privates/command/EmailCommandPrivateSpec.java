package az.rock.spec.auth.privates.command;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmailCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> addEmail(EmailCreateRequest email);
    ResponseEntity<JSuccessResponse> changeEmail(EmailChangeRequest request);

    ResponseEntity<JSuccessResponse> deleteEmail(UUID emailUUID);

    ResponseEntity<JSuccessResponse> setPrimaryEmail(UUID emailUUID);

    ResponseEntity<JSuccessResponse> switchEnableNotification(SwitchCase switchCase);

    ResponseEntity<JSuccessResponse> switchSubscribedPromotions(SwitchCase switchCase);


}
