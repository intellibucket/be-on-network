package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractTestQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.TestQueryPrivateSpec;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/tests",produces = MediaType.APPLICATION_JSON_VALUE)
@Profile({"local","develop"})
public class TestQueryPrivateController implements TestQueryPrivateSpec {

    private final AbstractTestQueryDomainPresentationService testQueryDomainPresentationService;

    public TestQueryPrivateController(AbstractTestQueryDomainPresentationService testQueryDomainPresentationService) {
        this.testQueryDomainPresentationService = testQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/case/1/{userId}")
    public ResponseEntity<JSuccessDataResponse<?>> case1(@PathVariable String userId) {
        var uuid = UUID.fromString(userId);
        this.testQueryDomainPresentationService.case1(uuid);
        return ResponseEntity.ok(new JSuccessDataResponse<>(userId));
    }
}
