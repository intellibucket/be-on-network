package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.EmailModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.EmailQueryPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/email",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailQueryPrivateController implements EmailQueryPrivateControllerSpec {

    @Override
    @GetMapping(value = "/get/model/my/{emailUUID}")
    public ResponseEntity<JSuccessDataResponse<EmailModelResponse>> getModel(@PathVariable(name = "emailUUID") UUID emailUUID) {
        return null;
    }

    @Override
    @GetMapping(value = "/get/model/all")
    public ResponseEntity<JSuccessDataResponse<List<EmailModelResponse>>> getAllModel() {
        return null;
    }

    @Override
    @GetMapping(value = "/get/uuid/all-uuid")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> getAllModelUUID() {
        return null;
    }

}
