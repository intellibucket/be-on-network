package az.rock.flyjob.js.presentation.api.rest.handler;

import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JsControllerAdvice {
    private final AbstractSecurityContextHolder securityContextHolder;

    public JsControllerAdvice(AbstractSecurityContextHolder securityContextHolder) {
        this.securityContextHolder = securityContextHolder;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JFailResponse> handleException(Exception exception) {
        exception.printStackTrace();
        if (this.securityContextHolder.isAuthenticated()) {
            var currentUserId = this.securityContextHolder.availableUser();
        }
        var message = exception.getMessage();

        if (exception instanceof ValidationException validationException) {
            message = validationException.getCause().getMessage();
        }
        if (message != null && message.startsWith("F0")) {
            var currentLang = this.securityContextHolder.currentLanguage();
            message = MessageBundle.fail(message, currentLang);
        }
        return ResponseEntity.badRequest().body(new JFailResponse(message));
    }
}
