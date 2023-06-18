package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractAccountPlanCommandDomainPresentationService;
import az.rock.lib.valueObject.CustomBugReport;
import org.springframework.stereotype.Service;

@Service
public class AccountPlanCommandDomainPresentationService implements AbstractAccountPlanCommandDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;

    public AccountPlanCommandDomainPresentationService(AbstractSecurityContextHolder securityContextHolder) {
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public void updatePlanToBasic() {

    }

    @Override
    public void updatePlanToUltimate() {

    }

    @Override
    public void updatePlanToBasicDemo() {

    }

    @Override
    public void updatePlanToUltimateDemo() {

    }

    @Override
    public void cancelCurrentPlan() {

    }

    @Override
    public void reportBug(CustomBugReport report) {

    }
}
