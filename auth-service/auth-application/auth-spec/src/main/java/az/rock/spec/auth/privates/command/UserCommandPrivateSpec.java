package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibucket.ws.validation.annotation.GPattern;
import org.springframework.http.ResponseEntity;

public interface UserCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> changeFirstName(String firstName);
    ResponseEntity<JSuccessResponse> changeLastName(String lastName);
    ResponseEntity<JSuccessResponse> changeUsername(@GPattern(message = "F0000000030")  String username);
    ResponseEntity<JSuccessResponse> changeGender(Gender gender);

    ResponseEntity<JSuccessResponse> changeTimezone(TimeZoneID timezone);


}
