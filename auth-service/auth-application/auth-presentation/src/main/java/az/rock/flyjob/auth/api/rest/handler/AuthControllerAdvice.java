package az.rock.flyjob.auth.api.rest.handler;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.AuthValidationException;
import az.rock.auth.domain.presentation.ports.input.advice.abstracts.AbstractExceptionPublisher;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthControllerAdvice {

    private final AbstractExceptionPublisher exceptionPublisher;
    private final AbstractSecurityContextHolder securityContextHolder;

    public AuthControllerAdvice(AbstractExceptionPublisher exceptionPublisher,
                                AbstractSecurityContextHolder securityContextHolder) {
        this.exceptionPublisher = exceptionPublisher;
        this.securityContextHolder = securityContextHolder;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JFailResponse> handleException(Exception exception) {
        exception.printStackTrace();
        var currentUserId  = this.securityContextHolder.currentUser();
        exceptionPublisher.publish(currentUserId, exception);
        return ResponseEntity.badRequest().body(new JFailResponse(exception.getMessage()));
    }


    @ExceptionHandler(AuthValidationException.class)
    public ResponseEntity<JFailResponse> handleException(AuthValidationException exception) {
        return ResponseEntity.badRequest().body(new JFailResponse(exception.getMessage()));
    }
}
