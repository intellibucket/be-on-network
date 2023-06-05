package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.CustomBugReport;
import az.rock.spec.auth.privates.command.AccountPlanCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/account-plan",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountPlanCommandPrivateController implements AccountPlanCommandPrivateSpec {
    @Override
    @PutMapping("/update-to-basic")
    public ResponseEntity<JSuccessResponse> updateToBasic() {
        return null;
    }

    @Override
    @PutMapping("/update-to-ultimate")
    public ResponseEntity<JSuccessResponse> updateToUltimate() {
        return null;
    }

    @Override
    @PutMapping("/update-to-basic-demo")
    public ResponseEntity<JSuccessResponse> updateToBasicDemo() {
        return null;
    }

    @Override
    @PutMapping("/update-to-ultimate-demo")
    public ResponseEntity<JSuccessResponse> updateToUltimateDemo() {
        return null;
    }

    @Override
    @PutMapping("/cancel-current-plan")
    public ResponseEntity<JSuccessResponse> cancelCurrentPlan() {
        return null;
    }

    @Override
    @PostMapping("/report-bug")
    public ResponseEntity<JSuccessResponse> reportBug(@RequestBody CustomBugReport report) {
        return null;
    }
}
