package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.AccountPlanQueryPrivateControllerSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/account-plan",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountPlanQueryPrivateController implements AccountPlanQueryPrivateControllerSpec {
    @Override
    @GetMapping("/active")
    public ResponseEntity<JSuccessDataResponse<AccountPlanPrivateModelResponse>> queryActiveAccountPlan() {
        return null;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<JSuccessDataResponse<AccountPlanPrivateModelResponse>> queryAllAccountPlans() {
        return null;
    }
}
