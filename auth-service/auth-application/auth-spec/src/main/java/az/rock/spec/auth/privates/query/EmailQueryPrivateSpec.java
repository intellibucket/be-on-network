package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.EmailClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.EmailPrivateModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface EmailQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<EmailPrivateModelResponse>> queryMyEmailById(UUID uuid);


    ResponseEntity<JSuccessDataResponse<EmailClientModelResponse>> queryAnyEmailByID(UUID uuid);
    ResponseEntity<JSuccessDataResponse<List<EmailPrivateModelResponse>>> queryMyAllEmails();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyAllEmailsID();


}
