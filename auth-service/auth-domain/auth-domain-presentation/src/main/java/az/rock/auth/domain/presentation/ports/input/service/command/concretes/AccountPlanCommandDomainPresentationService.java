package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.AbstractAccountPlanUpgradeCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractAccountPlanCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractAccountPlanMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.valueObject.AccountPlanType;
import az.rock.lib.valueObject.CustomBugReport;
import org.springframework.stereotype.Service;

@Service
public class AccountPlanCommandDomainPresentationService implements AbstractAccountPlanCommandDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter;
    private final AbstractAccountPlanUpgradeCommandHandler accountPlanUpgradeCommandHandler;
    private final AbstractAccountPlanMessagePublisher accountPlanPublisher;

    public AccountPlanCommandDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                       AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter,
                                                       AbstractAccountPlanUpgradeCommandHandler accountPlanUpgradeCommandHandler,
                                                       AbstractAccountPlanMessagePublisher accountPlanPublisher) {
        this.securityContextHolder = securityContextHolder;
        this.accountPlanQueryRepositoryAdapter = accountPlanQueryRepositoryAdapter;
        this.accountPlanUpgradeCommandHandler = accountPlanUpgradeCommandHandler;
        this.accountPlanPublisher = accountPlanPublisher;
    }

    private void updatePlan(AccountPlanType planType) {
        UpgradedAccountPlanEvent event = this.accountPlanUpgradeCommandHandler.handle(planType);
    }

    @Override
    public void updatePlanToBasic() {
        this.updatePlan(AccountPlanType.BASIC);

    }

    @Override
    public void updatePlanToUltimate() {
        this.updatePlan(AccountPlanType.ULTIMATE);
    }

    @Override
    public void updatePlanToBasicDemo() {
        this.updatePlan(AccountPlanType.BASIC_DEMO);
    }

    @Override
    public void updatePlanToUltimateDemo() {
        this.updatePlan(AccountPlanType.ULTIMATE_DEMO);
    }

    @Override
    public void cancelCurrentPlan() {
        this.updatePlan(AccountPlanType.FREE);
    }

    @Override
    public void reportBug(CustomBugReport report) {
        var currentUserID = this.securityContextHolder.availableUser();
    }
}
