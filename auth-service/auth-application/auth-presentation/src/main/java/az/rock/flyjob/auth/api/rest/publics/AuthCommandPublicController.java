package az.rock.flyjob.auth.api.rest.publics;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.publics.command.AuthCommandPublicControllerSpec;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/public/command/auth" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthCommandPublicController implements AuthCommandPublicControllerSpec {

    private final AbstractUserCommandDomainPresentationService userDomainPresentationService;

    public AuthCommandPublicController(AbstractUserCommandDomainPresentationService userDomainPresentationService) {
        this.userDomainPresentationService = userDomainPresentationService;
    }



    @Override
    @GetMapping(value = "/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(new JSuccessResponse("Success public result"));
    }



    @Override
    @PostMapping(value = "/registry/user")
    public ResponseEntity<JSuccessDataResponse<CreateUserResponse>> userRegistry(@RequestBody @Valid CreateUserCommand credentials) {
        var response  = this.userDomainPresentationService.createUser(credentials);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response,"Success private result"));
    }

    @Override
    @PostMapping(value = "/registry/company")
    public ResponseEntity<JSuccessDataResponse<CreateUserResponse>> companyRegistry(@RequestBody @Valid CreateUserCommand credentials) {
        var response  = this.userDomainPresentationService.createCompany(credentials);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response,"Success private result"));
    }

    @Override
    @PostMapping(value = "/forgot-password")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email) {
        return null;
    }

}
