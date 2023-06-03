package az.rock.auth.domain.presentation.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AbstractAccountPlanQueryDomainPresentation {
    AccountPlanPrivateModelResponse findCurrentAccountPlan();
}
