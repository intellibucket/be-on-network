package az.rock.spec.auth.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TestQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<?>> case1(String userId);
}
