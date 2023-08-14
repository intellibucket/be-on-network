package az.rock.flyjob.auth.api.rest.handler;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.advice.abstracts.AbstractExceptionPublisherService;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthControllerAdvice {

    private final AbstractExceptionPublisherService exceptionPublisher;
    private final AbstractSecurityContextHolder securityContextHolder;

    public AuthControllerAdvice(AbstractExceptionPublisherService exceptionPublisher,
                                AbstractSecurityContextHolder securityContextHolder) {
        this.exceptionPublisher = exceptionPublisher;
        this.securityContextHolder = securityContextHolder;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JFailResponse> handleException(Exception exception) {
        exception.printStackTrace();
        var currentUserId  = this.securityContextHolder.availableUser();
        var message = exception.getMessage();
        if (message != null && message.startsWith("F0")) {
            var currentLang = this.securityContextHolder.currentLanguage();
            message = MessageBundle.fail(message, currentLang);
        }
        // FIXME: 02.08.23 currentUserId bosh ola biler
        exceptionPublisher.publish(currentUserId, exception);
        return ResponseEntity.badRequest().body(new JFailResponse(message));
    }

}
