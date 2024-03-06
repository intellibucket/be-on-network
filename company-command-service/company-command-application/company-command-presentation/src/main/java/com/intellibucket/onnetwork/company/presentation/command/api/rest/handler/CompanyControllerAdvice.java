package com.intellibucket.onnetwork.company.presentation.command.api.rest.handler;

import az.rock.lib.jresponse.response.fail.JFailResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.advice.abstracts.AbstractExceptionPublisherService;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyControllerAdvice {

    private final AbstractExceptionPublisherService exceptionPublisher;
    private final AbstractSecurityContextHolder securityContextHolder;

    public CompanyControllerAdvice(AbstractExceptionPublisherService exceptionPublisher,
                                   AbstractSecurityContextHolder securityContextHolder) {
        this.exceptionPublisher = exceptionPublisher;
        this.securityContextHolder = securityContextHolder;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JFailResponse> handleException(Exception exception) {
        exception.printStackTrace();
        if (this.securityContextHolder.isAuthenticated()){
            var currentUserId  = this.securityContextHolder.currentUser();
            exceptionPublisher.publish(currentUserId, exception);
        }
        var message = exception.getMessage();

        if (exception instanceof ValidationException validationException){
            message = validationException.getCause().getMessage();
        }
        if (message != null && message.startsWith("F0")) {
            var currentLang = this.securityContextHolder.currentLanguage();
            message = MessageBundle.fail(message, currentLang);
        }
        return ResponseEntity.badRequest().body(new JFailResponse(message));
    }

}
