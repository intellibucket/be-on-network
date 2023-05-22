package az.rock.flyjob.auth.api.rest.publics;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.ports.input.service.abstracts.AbstractUserDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.publics.AuthGetPublicControllerSpec;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/1.0/public")
public class AuthPublicController implements AuthGetPublicControllerSpec {

    private final AbstractUserDomainPresentationService userDomainPresentationService;

    public AuthPublicController(AbstractUserDomainPresentationService userDomainPresentationService) {
        this.userDomainPresentationService = userDomainPresentationService;
    }


    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(new JSuccessResponse("Success public result"));
    }


    @Override
    @GetMapping("/registry")
    public ResponseEntity<JSuccessDataResponse<CreateUserResponse>> registry(@RequestBody @Valid CreateUserCommand credentials) {
        var response  = this.userDomainPresentationService.createUser(credentials);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response,"Success private result"));
    }

    @Override
    @PostMapping("/forgotPassword")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email) {
        return null;
    }

}
