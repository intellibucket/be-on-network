package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PhoneNumberQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<PhoneNumberPrivateModelResponse>> queryOwnById(UUID phoneNumberUUID);
    ResponseEntity<JSuccessDataResponse<PhoneNumberClientModelResponse>> queryAnyById(UUID phoneNumberUUID);
    ResponseEntity<JSuccessDataResponse<List<PhoneNumberPrivateModelResponse>>> queryOwnAll();
    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryOwnAllId();


}
