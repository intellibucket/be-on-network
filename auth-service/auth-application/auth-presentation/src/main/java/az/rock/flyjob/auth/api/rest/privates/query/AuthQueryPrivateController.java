package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.query.AuthQueryPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/auth",produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthQueryPrivateController implements AuthQueryPrivateControllerSpec {

    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(new JSuccessResponse("Success private result"));
    }

}
