package az.rock.spec.auth.publics;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthGetPublicControllerSpec {
    ResponseEntity<JSuccessResponse> live();

    @GetMapping("/registry")
    ResponseEntity<JSuccessDataResponse<CreateUserResponse>> registry(@RequestBody CreateUserCommand credentials);

    @PostMapping("/forgotPassword")
    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email);
}
