package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SwitchCase;
import az.rock.spec.auth.privates.command.EmailCommandPrivateControlSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/email",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailCommandPrivateController implements EmailCommandPrivateControlSpec {

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<JSuccessResponse> addEmail(@RequestBody String email) {
        return null;
    }

    @Override
    @PutMapping(value = "/change")
    public ResponseEntity<JSuccessResponse> changeEmail(@RequestBody EmailChangeRequest request) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<JSuccessResponse> deleteEmail(@PathVariable(name = "uuid") UUID emailUUID) {
        return null;
    }

    @Override
    @PutMapping(value = "/set-primary/{uuid}")
    public ResponseEntity<JSuccessResponse> setPrimaryEmail(@PathVariable(name = "uuid") UUID emailUUID) {
        return null;
    }

    @Override
    @PutMapping(value = "/switch-enable-notification")
    public ResponseEntity<JSuccessResponse> switchEnableNotification(@RequestBody SwitchCase switchCase){
        return null;
    }

    @Override
    @PutMapping(value = "/switch-subscribed-promotions")
    public ResponseEntity<JSuccessResponse> switchSubscribedPromotions(@RequestBody SwitchCase switchCase) {
        return null;
    }
}
