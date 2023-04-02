package az.rock.flyjob.auth.api.rest.publics;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.publics.AuthGetPublicControllerSpec;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/1.0/public")
public class AuthGetPublicController implements AuthGetPublicControllerSpec {


    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(new JSuccessResponse("Success public result"));
    }


    @Override
    @GetMapping("/registry")
    public ResponseEntity<JSuccessResponse> registry(@RequestBody @Valid CreateUserCommand credentials) {
        return ResponseEntity.ok(new JSuccessResponse("Success private result"));
    }

    @Override
    @PostMapping("/forgotPassword")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email) {
        return null;
    }

}
