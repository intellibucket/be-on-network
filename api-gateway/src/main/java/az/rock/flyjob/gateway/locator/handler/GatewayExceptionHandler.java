package az.rock.flyjob.gateway.locator.handler;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.jresponse.response.fail.JFailDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GatewayExceptionHandler {

    @ExceptionHandler(value = {JSecurityException.class})
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<JFailDataResponse<?>> jException(JSecurityException exception, WebRequest request) {
        var response = new JFailDataResponse<>(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ResponseEntity<JFailDataResponse<?>> exception(JSecurityException exception, WebRequest request) {
        var response = new JFailDataResponse<>(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }

}
