package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.EmailModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface EmailQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<EmailModelResponse>> getModel(UUID uuid);

    ResponseEntity<JSuccessDataResponse<List<EmailModelResponse>>> getAllModel();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> getAllModelUUID();


}
