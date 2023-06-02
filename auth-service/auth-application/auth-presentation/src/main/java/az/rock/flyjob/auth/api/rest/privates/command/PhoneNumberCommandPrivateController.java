package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import az.rock.spec.auth.privates.command.PhoneNumberCommandPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/phone-number",produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberCommandPrivateController implements PhoneNumberCommandPrivateControllerSpec {

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<JSuccessResponse> addPhoneNumber(@RequestBody PhoneNumberCommandRequest phoneNumberCommandRequest) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/delete/{phoneNumberUUID}")
    public ResponseEntity<JSuccessResponse> deletePhoneNumber(@PathVariable(name = "phoneNumberUUID") UUID phoneNumberUUID) {
        return null;
    }

    @Override
    @PutMapping(value = "/change")
    public ResponseEntity<JSuccessResponse> changePhoneNumber(@RequestBody PhoneNumberChangeRequest phoneNumberChangeRequest) {
        return null;
    }

    @Override
    @PutMapping(value = "/set-enable-sms-notification")
    public ResponseEntity<JSuccessResponse> setEnableSmsNotification(SwitchCase switchCase) {
        return null;
    }

    @Override
    @PutMapping(value = "/set-enable-whatsapp-notification")
    public ResponseEntity<JSuccessResponse> setEnableWhatsappNotification(SwitchCase switchCase) {
        return null;
    }

    @Override
    @PutMapping(value = "/set-primary")
    public ResponseEntity<JSuccessResponse> setPrimary(SwitchCase switchCase) {
        return null;
    }
}
