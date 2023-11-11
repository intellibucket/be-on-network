package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import az.rock.spec.auth.privates.command.UserCommandPrivateSpec;
import com.intellibucket.ws.validation.annotation.GPattern;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/user",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserCommandPrivateController implements UserCommandPrivateSpec {

    private final AbstractUserCommandDomainPresentationService userCommandDomainPresentationService;

    public UserCommandPrivateController(AbstractUserCommandDomainPresentationService userCommandDomainPresentationService) {
        this.userCommandDomainPresentationService = userCommandDomainPresentationService;
    }


    @Override
    @PutMapping("/change-first-name")
    public ResponseEntity<JSuccessResponse> changeFirstName(@RequestParam("firstName") String firstName) {
        this.userCommandDomainPresentationService.changeFirstName(firstName);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/change-last-name")
    public ResponseEntity<JSuccessResponse> changeLastName(@RequestParam("lastName") String lastName) {
        this.userCommandDomainPresentationService.changeLastName(lastName);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/change-username")
    public ResponseEntity<JSuccessResponse> changeUsername(@RequestParam("username")  String username) {
        this.userCommandDomainPresentationService.changeUsername(username);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/change-gender")
    public ResponseEntity<JSuccessResponse> changeGender(@RequestParam("gender") Gender gender) {
        this.userCommandDomainPresentationService.changeGender(gender);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/change-timezone")
    public ResponseEntity<JSuccessResponse> changeTimezone(@RequestParam("timezone") String timezone) {
        this.userCommandDomainPresentationService.changeTimezone(TimeZoneID.of(timezone));
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    public ResponseEntity<JSuccessResponse> changeTitle(String title) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> changeBiography(String biography) {
        return null;
    }
}
