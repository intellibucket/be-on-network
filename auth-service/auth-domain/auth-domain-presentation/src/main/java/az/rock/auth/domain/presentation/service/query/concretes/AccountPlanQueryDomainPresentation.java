package az.rock.auth.domain.presentation.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractAccountPlanQueryDomainPresentation;
import org.springframework.stereotype.Service;

@Service
public class AccountPlanQueryDomainPresentation implements AbstractAccountPlanQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter;

    public AccountPlanQueryDomainPresentation(AbstractSecurityContextHolder securityContextHolder,
                                              AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.accountPlanQueryRepositoryAdapter = accountPlanQueryRepositoryAdapter;
    }

    @Override
    public AccountPlanPrivateModelResponse findCurrentAccountPlan() {
        var currentUser = this.securityContextHolder.currentUser();
        var accountPlan = this.accountPlanQueryRepositoryAdapter.findByPID(currentUser);
        return AccountPlanPrivateModelResponse.of(accountPlan);
    }
}
