package az.rock.spec.auth.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

public interface AuthGetPrivateControllerSpec {
    ResponseEntity<JSuccessResponse> live();

}
