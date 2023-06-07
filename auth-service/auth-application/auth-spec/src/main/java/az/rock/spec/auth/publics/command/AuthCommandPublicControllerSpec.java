package az.rock.spec.auth.publics.command;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;


public interface AuthCommandPublicControllerSpec {
    ResponseEntity<JSuccessResponse> live();

    ResponseEntity<JSuccessDataResponse<CreateUserResponse>> userRegistry(CreateUserCommand credentials);

    ResponseEntity<JSuccessDataResponse<CreateUserResponse>> companyRegistry(CreateUserCommand credentials);


    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email);
}
