package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

public interface AccountPlanQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<AccountPlanPrivateModelResponse>> queryActiveAccountPlan();
    ResponseEntity<JSuccessDataResponse<AccountPlanPrivateModelResponse>> queryAllAccountPlans();
}
