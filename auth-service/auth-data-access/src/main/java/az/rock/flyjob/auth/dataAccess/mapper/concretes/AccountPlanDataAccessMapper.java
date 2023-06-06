package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AccountPlanDataAccessMapper implements AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> {

    @Override
    public Optional<AccountPlanRoot> toRoot(AccountPlanEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(AccountPlanRoot.Builder
                .builder()
                .accountPlanID(AccountPlanID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .rowStatus(entity.getRowStatus())
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .plan(entity.getPlan())
                .startDate(GDateTime.of(entity.getStartDate()))
                .expiredDate(GDateTime.of(entity.getExpiredDate()))
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
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .plan(root.getPlan())
                .startDate(GDateTime.of(root.getStartDate()))
                .expiredDate(GDateTime.of(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build());
    }

    @Override
    public Optional<AccountPlanEntity> toNewEntity(AccountPlanRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(AccountPlanEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .plan(root.getPlan())
                .startDate(GDateTime.of(root.getStartDate()))
                .expiredDate(GDateTime.of(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build());
    }
}
