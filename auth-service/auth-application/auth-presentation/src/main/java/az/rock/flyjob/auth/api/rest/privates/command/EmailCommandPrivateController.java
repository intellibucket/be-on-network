package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractEmailCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import az.rock.spec.auth.privates.command.EmailCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailCommandPrivateController implements EmailCommandPrivateSpec {

    private final AbstractEmailCommandDomainPresentationService emailCommandDomainPresentationService;

    public EmailCommandPrivateController(AbstractEmailCommandDomainPresentationService emailCommandDomainPresentationService) {
        this.emailCommandDomainPresentationService = emailCommandDomainPresentationService;
    }

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<JSuccessResponse> addEmail(@RequestBody EmailCreateRequest email) {
        this.emailCommandDomainPresentationService.add(email);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping(value = "/change")
    public ResponseEntity<JSuccessResponse> changeEmail(@RequestBody EmailChangeRequest request) {
        this.emailCommandDomainPresentationService.change(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<JSuccessResponse> deleteEmail(@PathVariable(name = "uuid") UUID emailUUID) {
        this.emailCommandDomainPresentationService.delete(emailUUID);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping(value = "/set-primary/{uuid}")
    public ResponseEntity<JSuccessResponse> setPrimaryEmail(@PathVariable(name = "uuid") UUID emailUUID) {
        this.emailCommandDomainPresentationService.setPrimary(emailUUID);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping(value = "/switch-enable-notification")
    public ResponseEntity<JSuccessResponse> switchEnableNotification(@RequestBody SwitchCase switchCase) {
        this.emailCommandDomainPresentationService.switchEnableNotification(switchCase);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping(value = "/switch-subscribed-promotions")
    public ResponseEntity<JSuccessResponse> switchSubscribedPromotions(@RequestBody SwitchCase switchCase) {
        this.emailCommandDomainPresentationService.switchSubscribedPromotions(switchCase);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
