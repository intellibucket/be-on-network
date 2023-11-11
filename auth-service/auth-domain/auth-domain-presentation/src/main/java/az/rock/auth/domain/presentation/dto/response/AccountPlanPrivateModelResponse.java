package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.valueObject.AccountPlanType;

import java.time.ZonedDateTime;
import java.util.UUID;

public record AccountPlanPrivateModelResponse(UUID uuid, AccountPlanType plan, ZonedDateTime startDate,
                                              ZonedDateTime expiredDate, Boolean isExpired) {
    private AccountPlanPrivateModelResponse(AccountPlanRoot root){
        this(root.getRootID().getAbsoluteID(), root.getPlan(), root.getStartDate(), root.getExpiredDate(), root.getExpired());
    }

    public static AccountPlanPrivateModelResponse of(AccountPlanRoot root){
        return new AccountPlanPrivateModelResponse(root);
    }
}
