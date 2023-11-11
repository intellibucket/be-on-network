package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibucket.ws.validation.annotation.GPattern;
import org.springframework.http.ResponseEntity;

public interface UserCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> changeFirstName(
            @GPattern(message = "F0000000034",pattern = "^[a-zA-Z0-9_-]{3,16}$")
            String firstName);
    ResponseEntity<JSuccessResponse> changeLastName(
            @GPattern(message = "F0000000035",pattern = "^[a-zA-Z0-9_-]{3,16}$")
            String lastName);
    ResponseEntity<JSuccessResponse> changeUsername(
            @GPattern(message = "F0000000030",pattern = "^[a-zA-Z0-9_-]{3,16}$")
            String username);
    ResponseEntity<JSuccessResponse> changeGender(Gender gender);
    ResponseEntity<JSuccessResponse> changeTimezone(String timezone);

    ResponseEntity<JSuccessResponse> changeTitle(String title);

    ResponseEntity<JSuccessResponse> changeBiography(String biography);
}
