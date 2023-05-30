package az.rock.flyjob.auth.api.rest.handler;

import az.rock.auth.domain.presentation.exception.AuthValidationException;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthControllerAdvice {

    @ExceptionHandler(AuthValidationException.class)
    public ResponseEntity<JFailResponse> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new JFailResponse(exception.getMessage()));
    }
}
