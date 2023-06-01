package az.rock.spec.auth.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

public interface AuthQueryPrivateControllerSpec {
    ResponseEntity<JSuccessResponse> live();

}
