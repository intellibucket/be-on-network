package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractTestCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/tests", produces = MediaType.APPLICATION_JSON_VALUE)
@Profile({"local", "pre-develop", "develop"})
public class TestCommandPrivateController {
    private final AbstractTestCommandDomainPresentationService testCommandDomainPresentationService;

    public TestCommandPrivateController(AbstractTestCommandDomainPresentationService testCommandDomainPresentationService) {
        this.testCommandDomainPresentationService = testCommandDomainPresentationService;
    }


    @GetMapping("/rollback/user/{uuid}")
    public ResponseEntity<JSuccessResponse> rollbackUser(@PathVariable String uuid) {
        this.testCommandDomainPresentationService.testRollbackForUser(UUID.fromString(uuid));
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
