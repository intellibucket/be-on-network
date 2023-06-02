package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import az.rock.spec.auth.privates.command.UserCommandPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserCommandPrivateController implements UserCommandPrivateControllerSpec {

    @Override
    @PutMapping("/change-first-name")
    public ResponseEntity<JSuccessResponse> changeFirstName(@RequestBody String firstName) {
        return null;
    }

    @Override
    @PutMapping("/change-last-name")
    public ResponseEntity<JSuccessResponse> changeLastName(@RequestBody String lastName) {
        return null;
    }

    @Override
    @PutMapping("/change-username")
    public ResponseEntity<JSuccessResponse> changeUsername(@RequestBody String username) {
        return null;
    }

    @Override
    @PutMapping("/change-gender")
    public ResponseEntity<JSuccessResponse> changeGender(@RequestBody Gender gender) {
        return null;
    }

    @Override
    @PutMapping("/change-timezone")
    public ResponseEntity<JSuccessResponse> changeTimezone(@RequestBody TimeZoneID timezone) {
        return null;
    }
}
