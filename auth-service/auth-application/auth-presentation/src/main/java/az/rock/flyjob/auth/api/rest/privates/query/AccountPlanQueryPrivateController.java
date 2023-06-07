package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractAccountPlanQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.AccountPlanQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/account-plan",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountPlanQueryPrivateController implements AccountPlanQueryPrivateSpec {
    private final AbstractAccountPlanQueryDomainPresentation accountPlanQueryDomainPresentation;

    public AccountPlanQueryPrivateController(AbstractAccountPlanQueryDomainPresentation accountPlanQueryDomainPresentation) {
        this.accountPlanQueryDomainPresentation = accountPlanQueryDomainPresentation;
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<JSuccessDataResponse<AccountPlanPrivateModelResponse>> queryActiveAccountPlan() {
        var response = this.accountPlanQueryDomainPresentation.findCurrentAccountPlan();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<JSuccessDataResponse<List<AccountPlanPrivateModelResponse>>> queryAllAccountPlans() {
        var response = this.accountPlanQueryDomainPresentation.findAllAccountPlans();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}
