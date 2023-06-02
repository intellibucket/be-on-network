package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateDetailModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PhoneNumberQueryPrivateControllerSpec {
    ResponseEntity<JSuccessDataResponse<PhoneNumberPrivateDetailModelResponse>> queryById(UUID phoneNumberUUID);
    ResponseEntity<JSuccessDataResponse<List<PhoneNumberPrivateDetailModelResponse>>> queryAll();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryAllUuid();


}
