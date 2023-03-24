package az.rock.flyjob.auth.api.rest.publics;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.AuthGetPrivateControllerSpec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/1.0/public")
public class AuthGetPublicController implements AuthGetPrivateControllerSpec {


    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(new JSuccessResponse("Success public result"));
    }

}
