package az.rock.flyjob.auth.api.rest.privates;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.AuthGetPrivateControllerSpec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/1.0/private")
public class AuthGetPrivateController implements AuthGetPrivateControllerSpec {
    private final AbstractJSuccessResponseFactory<?> responseFactory;

    public AuthGetPrivateController(AbstractJSuccessResponseFactory<?> responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(this.responseFactory.factoryResponse("Success"));
    }

}
