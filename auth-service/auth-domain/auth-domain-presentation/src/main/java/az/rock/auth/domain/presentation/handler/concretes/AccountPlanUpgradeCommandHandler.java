package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractAccountPlanUpgradeCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractAccountPlanDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractAccountPlanCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractDetailQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.flyjob.auth.service.abstracts.AbstractAccountPlanDomainService;
import az.rock.lib.valueObject.AccountPlanType;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanUpgradeCommandHandler implements AbstractAccountPlanUpgradeCommandHandler {

    private final AbstractAccountPlanDomainService accountPlanDomainService;
    private final AbstractAccountPlanCommandRepositoryAdapter accountPlanCommandRepositoryAdapter;
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter;
    private final AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter;
    private final AbstractAccountPlanDomainMapper accountPlanDomainMapper;

    public AccountPlanUpgradeCommandHandler(AbstractAccountPlanDomainService accountPlanDomainService,
                                            AbstractAccountPlanCommandRepositoryAdapter accountPlanCommandRepositoryAdapter,
                                            AbstractSecurityContextHolder securityContextHolder,
                                            AbstractAccountPlanQueryRepositoryAdapter accountPlanQueryRepositoryAdapter,
                                            AbstractDetailQueryRepositoryAdapter detailQueryRepositoryAdapter,
                                            AbstractAccountPlanDomainMapper accountPlanDomainMapper) {
        this.accountPlanDomainService = accountPlanDomainService;
        this.accountPlanCommandRepositoryAdapter = accountPlanCommandRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
        this.accountPlanQueryRepositoryAdapter = accountPlanQueryRepositoryAdapter;
        this.detailQueryRepositoryAdapter = detailQueryRepositoryAdapter;
        this.accountPlanDomainMapper = accountPlanDomainMapper;
    }

    @Override
    public UpgradedAccountPlanEvent handle(AccountPlanType plan) {
        var currentUserID = this.securityContextHolder.availableUser();
        var optionalCurrentUserDetail = this.detailQueryRepositoryAdapter.findByPID(currentUserID);
        var optionalCurrentAccountPlan = this.accountPlanQueryRepositoryAdapter.findByPID(currentUserID);
        if (optionalCurrentUserDetail.isPresent() && optionalCurrentAccountPlan.isPresent() && optionalCurrentUserDetail.get().isAvailable()) {
            var currentAccountPlan = optionalCurrentAccountPlan.get();
            var latestPlanActions = this.accountPlanQueryRepositoryAdapter.findAllUnCompletedAccountPlanByPID(currentUserID);
            if (!latestPlanActions.isEmpty()) throw new AuthDomainPresentationException("F0000000021");
            this.accountPlanDomainService.validateForUpgrade(currentAccountPlan, plan);
            var onWaitingAccountPlan = this.accountPlanDomainMapper.createOnWaitingAccountPlan(currentUserID, plan);
            this.accountPlanCommandRepositoryAdapter.create(onWaitingAccountPlan);
            return UpgradedAccountPlanEvent.of(optionalCurrentAccountPlan.get());
        } else throw new AuthDomainPresentationException("F0000000019");
    }
}
