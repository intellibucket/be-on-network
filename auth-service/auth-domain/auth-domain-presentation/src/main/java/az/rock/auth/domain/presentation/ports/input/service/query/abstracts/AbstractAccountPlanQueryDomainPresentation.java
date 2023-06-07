package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AbstractAccountPlanQueryDomainPresentation {
    AccountPlanPrivateModelResponse findCurrentAccountPlan();

    List<AccountPlanPrivateModelResponse> findAllAccountPlans();
}
