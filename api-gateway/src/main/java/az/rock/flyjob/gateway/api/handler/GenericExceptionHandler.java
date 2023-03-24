package az.rock.flyjob.gateway.api.handler;

import az.rock.lib.jresponse.response.fail.JFailResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Component
public class GenericExceptionHandler extends DefaultErrorAttributes {

    @Override
    public final Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable error = this.getError(request);
        MergedAnnotation<ResponseStatus> responseStatusAnnotation =
                MergedAnnotations.from(error.getClass(), MergedAnnotations.SearchStrategy.TYPE_HIERARCHY).get(ResponseStatus.class);
        HttpStatus errorStatus = this.findHttpStatus(error, responseStatusAnnotation);
        var failResponse = ServerFailPattern.resolve(errorStatus.value()).get();
        Map<String, Object> map = this.resolve(request, options, failResponse);
        return map;
    }

    private Map<String, Object> resolve(ServerRequest request, ErrorAttributeOptions options, JFailResponse failResponse) {
        Map<String, Object> map = super.getErrorAttributes(request, options);
        map.remove("timestamp");
        map.remove("path");
        map.remove("error");
        map.remove("requestId");
        map.remove("trace");

        map.put("trackId", failResponse.getTrackId());
        map.put("success", false);
        map.put("message", failResponse.getMessage());
        map.put("time", failResponse.getTime());
        return map;
    }

    private HttpStatus findHttpStatus(Throwable error, MergedAnnotation<ResponseStatus> responseStatusAnnotation) {
        if (error instanceof ResponseStatusException errorStatus)
            return HttpStatus.resolve(errorStatus.getStatusCode().value());
        return responseStatusAnnotation.getValue("code", HttpStatus.class).orElse(INTERNAL_SERVER_ERROR);
    }

}