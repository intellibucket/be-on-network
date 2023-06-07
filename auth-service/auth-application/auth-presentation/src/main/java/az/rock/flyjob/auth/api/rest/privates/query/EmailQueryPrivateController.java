package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.EmailClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.EmailPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractEmailQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.EmailQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/email",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailQueryPrivateController implements EmailQueryPrivateSpec {

    private final AbstractEmailQueryDomainPresentationService emailQueryDomainPresentationService;

    public EmailQueryPrivateController(AbstractEmailQueryDomainPresentationService emailQueryDomainPresentationService) {
        this.emailQueryDomainPresentationService = emailQueryDomainPresentationService;
    }


    @Override
    @GetMapping(value = "/get-my/{emailUUID}")
    public ResponseEntity<JSuccessDataResponse<EmailPrivateModelResponse>> queryMyEmailById(@PathVariable(name = "emailUUID") UUID emailUUID) {
        var response = this.emailQueryDomainPresentationService.queryMyEmailById(emailUUID);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @GetMapping(value = "/get-any/{emailUUID}")
    public ResponseEntity<JSuccessDataResponse<EmailClientModelResponse>> queryAnyEmailByID(@PathVariable(name = "emailUUID") UUID emailUUID) {
        var response = this.emailQueryDomainPresentationService.queryAnyEmailByID(emailUUID);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-my/all")
    public ResponseEntity<JSuccessDataResponse<List<EmailPrivateModelResponse>>> queryMyAllEmails() {
        var response = this.emailQueryDomainPresentationService.queryMyAllEmails();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-my/all-uuids")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyAllEmailsID() {
        var response = this.emailQueryDomainPresentationService.queryMyAllEmailsID();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }


}
