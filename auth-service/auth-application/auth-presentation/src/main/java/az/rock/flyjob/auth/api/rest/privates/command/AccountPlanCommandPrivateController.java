package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractAccountPlanCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.CustomBugReport;
import az.rock.spec.auth.privates.command.AccountPlanCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/account-plan", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountPlanCommandPrivateController implements AccountPlanCommandPrivateSpec {
    private final AbstractAccountPlanCommandDomainPresentationService accountPlanCommandDomainPresentationService;

    public AccountPlanCommandPrivateController(AbstractAccountPlanCommandDomainPresentationService accountPlanCommandDomainPresentationService) {
        this.accountPlanCommandDomainPresentationService = accountPlanCommandDomainPresentationService;
    }

    @Override
    @PutMapping("/update-to-basic")
    public ResponseEntity<JSuccessResponse> updateToBasic() {
        this.accountPlanCommandDomainPresentationService.updatePlanToBasic();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update-to-ultimate")
    public ResponseEntity<JSuccessResponse> updateToUltimate() {
        this.accountPlanCommandDomainPresentationService.updatePlanToUltimate();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update-to-basic-demo")
    public ResponseEntity<JSuccessResponse> updateToBasicDemo() {
        this.accountPlanCommandDomainPresentationService.updatePlanToBasicDemo();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update-to-ultimate-demo")
    public ResponseEntity<JSuccessResponse> updateToUltimateDemo() {
        this.accountPlanCommandDomainPresentationService.updatePlanToUltimateDemo();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/cancel-current-plan")
    public ResponseEntity<JSuccessResponse> cancelCurrentPlan() {
        this.accountPlanCommandDomainPresentationService.cancelCurrentPlan();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/report-bug")
    public ResponseEntity<JSuccessResponse> reportBug(@RequestBody CustomBugReport report) {
        this.accountPlanCommandDomainPresentationService.reportBug(report);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
