package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.PhoneNumberClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.PhoneNumberPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractPhoneNumberQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.PhoneNumberQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/phone-number",produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberQueryPrivateController implements PhoneNumberQueryPrivateSpec {
    private final AbstractPhoneNumberQueryDomainPresentationService phoneNumberQueryDomainPresentationService;

    public PhoneNumberQueryPrivateController(AbstractPhoneNumberQueryDomainPresentationService phoneNumberQueryDomainPresentationService) {
        this.phoneNumberQueryDomainPresentationService = phoneNumberQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-my/{phoneNumberUUID}")
    public ResponseEntity<JSuccessDataResponse<PhoneNumberPrivateModelResponse>> queryOwnById(@PathVariable(value = "phoneNumberUUID") UUID phoneNumberUUID) {
        var response = this.phoneNumberQueryDomainPresentationService.queryOwnById(phoneNumberUUID);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-any/{phoneNumberUUID}")
    public ResponseEntity<JSuccessDataResponse<PhoneNumberClientModelResponse>> queryAnyById(@PathVariable(value = "phoneNumberUUID") UUID phoneNumberUUID) {
        var response = this.phoneNumberQueryDomainPresentationService.queryAnyById(phoneNumberUUID);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-my/all")
    public ResponseEntity<JSuccessDataResponse<List<PhoneNumberPrivateModelResponse>>> queryOwnAll() {
        var response = this.phoneNumberQueryDomainPresentationService.queryOwnAll();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-my/all-uuids")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryOwnAllId() {
        var response = this.phoneNumberQueryDomainPresentationService.queryOwnAllId();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}
