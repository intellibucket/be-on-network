package az.rock.auth.domain.presentation.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractAccountPlanQueryDomainPresentation;
import org.springframework.stereotype.Service;

import java.util.List;

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
        var accountPlan = this.accountPlanQueryRepositoryAdapter.findByPIDAndActiveStatus(currentUser);
        return AccountPlanPrivateModelResponse.of(accountPlan);
    }

    @Override
    public List<AccountPlanPrivateModelResponse> findAllAccountPlans() {
        var currentUser = this.securityContextHolder.currentUser();
        var accountPlan = this.accountPlanQueryRepositoryAdapter.findAllByPIDAndActiveStatus(currentUser);
        return accountPlan.stream().map(AccountPlanPrivateModelResponse::of).toList();
    }
}
