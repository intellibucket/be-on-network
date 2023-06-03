package az.rock.auth.domain.presentation.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.AccountPlanPrivateModelResponse;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractAccountPlanQueryDomainPresentation;
import org.springframework.stereotype.Service;

@Service
public class AccountPlanQueryDomainPresentation implements AbstractAccountPlanQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;

    public AccountPlanQueryDomainPresentation(AbstractSecurityContextHolder securityContextHolder) {
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public AccountPlanPrivateModelResponse findCurrentAccountPlan() {
        return null;
    }
}
