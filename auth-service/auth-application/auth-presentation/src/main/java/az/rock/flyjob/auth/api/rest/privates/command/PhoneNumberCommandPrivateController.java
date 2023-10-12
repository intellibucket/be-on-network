package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractPhoneNumberCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import az.rock.spec.auth.privates.command.PhoneNumberCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/phone-number", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberCommandPrivateController implements PhoneNumberCommandPrivateSpec {

    private final AbstractPhoneNumberCommandDomainPresentationService phoneNumberCommandDomainPresentationService;

    public PhoneNumberCommandPrivateController(AbstractPhoneNumberCommandDomainPresentationService phoneNumberCommandDomainPresentationService) {
        this.phoneNumberCommandDomainPresentationService = phoneNumberCommandDomainPresentationService;
    }

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<JSuccessResponse> addPhoneNumber(@RequestBody PhoneNumberCommandRequest phoneNumberCommandRequest) {
        this.phoneNumberCommandDomainPresentationService.add(phoneNumberCommandRequest);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping(value = "/delete/{phoneNumberUUID}")
    public ResponseEntity<JSuccessResponse> deletePhoneNumber(@PathVariable(name = "phoneNumberUUID") UUID phoneNumberUUID) {
        this.phoneNumberCommandDomainPresentationService.delete(phoneNumberUUID);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping(value = "/change")
    public ResponseEntity<JSuccessResponse> changePhoneNumber(@RequestBody PhoneNumberChangeRequest phoneNumberChangeRequest) {
        this.phoneNumberCommandDomainPresentationService.change(phoneNumberChangeRequest);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping(value = "/set-enable-sms-notification")
    public ResponseEntity<JSuccessResponse> setEnableSmsNotification(SwitchCase switchCase) {
        this.phoneNumberCommandDomainPresentationService.enableSmsNotification(switchCase);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping(value = "/set-enable-whatsapp-notification")
    public ResponseEntity<JSuccessResponse> setEnableWhatsappNotification(SwitchCase switchCase) {
        this.phoneNumberCommandDomainPresentationService.enableWhatsappNotification(switchCase);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping(value = "/set-primary")
    public ResponseEntity<JSuccessResponse> setPrimary(SwitchCase switchCase) {
        this.phoneNumberCommandDomainPresentationService.setPrimary(switchCase);
        return ResponseEntity.ok(JSuccessResponse.success());
    }
}
