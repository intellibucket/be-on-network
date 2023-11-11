package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.auth.AccountPlanID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountPlanDataAccessMapper implements AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> {

    @Override
    public Optional<AccountPlanRoot> toRoot(AccountPlanEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        var currentUserId = UserID.of(entity.getUser().getUuid());
        return Optional.of(
                AccountPlanRoot.Builder
                        .builder()
                        .accountPlanID(AccountPlanID.of(entity.getUuid()))
                        .version(entity.getVersion())
                        .processStatus(entity.getProcessStatus())
                        .rowStatus(entity.getRowStatus())
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .plan(entity.getPlan())
                        .user(currentUserId)
                        .startDate(GDateTime.toZonedDateTime(entity.getStartDate()))
                        .expiredDate(GDateTime.toZonedDateTime(entity.getExpiredDate()))
                        .isExpired(entity.getIsExpired())
                        .promoCode(entity.getPromoCode())
                        .build());
    }

    @Override
    public Optional<AccountPlanEntity> toEntity(AccountPlanRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(AccountPlanEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .plan(root.getPlan())
                .startDate(GDateTime.toTimestamp(root.getStartDate()))
                .expiredDate(GDateTime.toTimestamp(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build());
    }

    @Override
    public Optional<AccountPlanEntity> toNewEntity(AccountPlanRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        var userEntityID = UserEntity.referenceObject(root.getUserID().getAbsoluteID());
        return Optional.of(AccountPlanEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .plan(root.getPlan())
                .userEntity(userEntityID)
                .startDate(GDateTime.toTimestamp(root.getStartDate()))
                .expiredDate(GDateTime.toTimestamp(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build());
    }
}
