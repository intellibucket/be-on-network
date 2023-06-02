package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.http.ResponseEntity;

public interface UserCommandPrivateControllerSpec {

    ResponseEntity<JSuccessResponse> changeFirstName(String firstName);
    ResponseEntity<JSuccessResponse> changeLastName(String lastName);
    ResponseEntity<JSuccessResponse> changeUsername(String username);
    ResponseEntity<JSuccessResponse> changeGender(Gender gender);

    ResponseEntity<JSuccessResponse> changeTimezone(TimeZoneID timezone);


}
