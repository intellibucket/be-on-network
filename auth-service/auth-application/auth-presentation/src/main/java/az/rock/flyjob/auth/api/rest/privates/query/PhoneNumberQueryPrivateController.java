package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateDetailModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.PhoneNumberQueryPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/phone-number",produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberQueryPrivateController implements PhoneNumberQueryPrivateControllerSpec {
    @Override
    @GetMapping(value = "/query-model-by-id")
    public ResponseEntity<JSuccessDataResponse<PhoneNumberPrivateDetailModelResponse>> queryById(UUID phoneNumberUUID) {
        return null;
    }

    @Override
    @GetMapping(value = "/query-model-all")
    public ResponseEntity<JSuccessDataResponse<List<PhoneNumberPrivateDetailModelResponse>>> queryAll() {
        return null;
    }

    @Override
    @GetMapping(value = "/query-uuid-all")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryAllUuid() {
        return null;
    }
}
