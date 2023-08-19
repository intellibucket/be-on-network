package az.rock.flyjob.js.presentation.api.rest.privates.command;

import az.rock.flyjob.js.domain.presentation.ports.input.service.command.abstracts.AbstractPrivateOrganizationCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.PrivateOrganizationCommandControllerSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/job-search", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrivateOrganizationCommandController implements PrivateOrganizationCommandControllerSpec {

    private final AbstractPrivateOrganizationCommandDomainPresentationService privateOrganizationCommandDomainPresentationService;

    public PrivateOrganizationCommandController(AbstractPrivateOrganizationCommandDomainPresentationService privateOrganizationCommandDomainPresentationService) {
        this.privateOrganizationCommandDomainPresentationService = privateOrganizationCommandDomainPresentationService;
    }


    @Override
    @GetMapping("/search-job")
    public ResponseEntity<JSuccessResponse> searchJob() {
        this.privateOrganizationCommandDomainPresentationService.searchJob();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/add-job")
        public ResponseEntity<JSuccessResponse> addJob() {
        this.privateOrganizationCommandDomainPresentationService.addJob();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping("/delete-job")
        public ResponseEntity<JSuccessResponse> deleteJob() {
        this.privateOrganizationCommandDomainPresentationService.deleteJob();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    public ResponseEntity<JSuccessResponse> upgradeJobToPremium() {
        return null;
    }

    @Override
    @PutMapping("/upgrade-job-to-ultimate")
        public ResponseEntity<JSuccessResponse> upgradeJobToUltimate() {
        this.privateOrganizationCommandDomainPresentationService.upgradeJobToUltimate();
        return ResponseEntity.ok(new JSuccessResponse());
        }
}
