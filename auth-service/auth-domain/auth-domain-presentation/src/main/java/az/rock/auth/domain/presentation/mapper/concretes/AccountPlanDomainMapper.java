package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractAccountPlanDomainMapper;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.AccountPlanType;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class AccountPlanDomainMapper implements AbstractAccountPlanDomainMapper {
    @Override
    public AccountPlanRoot freeAccountPlan(UserID userID) {
        return AccountPlanRoot.Builder
                .builder()
                .accountPlanID(AccountPlanID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .user(userID)
                .plan(AccountPlanType.FREE)
                .startDate(ZonedDateTime.now())
                .expiredDate(ZonedDateTime.now().plusYears(10))
                .isExpired(false)
                .build();
    }

    @Override
    public AccountPlanRoot createOnWaitingAccountPlan(UserID userID, AccountPlanType plan) {
        return AccountPlanRoot.Builder
                .builder()
                .accountPlanID(AccountPlanID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.ON_WAITING_FOR_PAYMENT)
                .rowStatus(RowStatus.ACTIVE)
                .user(userID)
                .plan(plan)
                .startDate(ZonedDateTime.now())
                .expiredDate(ZonedDateTime.now().plusMonths(1))
                .isExpired(false)
                .build();
    }
}
