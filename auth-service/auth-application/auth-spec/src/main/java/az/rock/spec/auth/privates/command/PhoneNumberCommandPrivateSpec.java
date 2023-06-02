package az.rock.spec.auth.privates.command;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PhoneNumberCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> addPhoneNumber(PhoneNumberCommandRequest phoneNumberCommandRequest);
    ResponseEntity<JSuccessResponse> deletePhoneNumber(UUID phoneNumberUUID);
    ResponseEntity<JSuccessResponse> changePhoneNumber(PhoneNumberChangeRequest phoneNumberChangeRequest);

    ResponseEntity<JSuccessResponse> setEnableSmsNotification(SwitchCase switchCase);
    ResponseEntity<JSuccessResponse> setEnableWhatsappNotification(SwitchCase switchCase);
    ResponseEntity<JSuccessResponse> setPrimary(SwitchCase switchCase);

}
