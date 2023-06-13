package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@InputPort
@Transactional(readOnly = true)
public interface AbstractAccountPlanQueryDomainPresentation {
    AccountPlanPrivateModelResponse findCurrentAccountPlan();

    List<AccountPlanPrivateModelResponse> findAllAccountPlans();
}
