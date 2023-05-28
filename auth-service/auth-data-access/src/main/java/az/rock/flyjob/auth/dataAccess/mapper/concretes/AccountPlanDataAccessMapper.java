package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountPlanDataAccessMapper implements AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> {

    private final UserDataAccessMapper userDataAccessMapper;

    public AccountPlanDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public AccountPlanRoot toRoot(AccountPlanEntity entity) {
        return AccountPlanRoot.Builder
                .builder()
                .accountPlanID(AccountPlanID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .rowStatus(entity.getDataStatus())
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .plan(entity.getPlan())
                .startDate(GDateTime.of(entity.getStartDate()))
                .expiredDate(GDateTime.of(entity.getExpiredDate()))
                .isExpired(entity.getIsExpired())
                .promoCode(entity.getPromoCode())
                .build();
    }

    @Override
    public AccountPlanEntity toEntity(AccountPlanRoot root) {
        return AccountPlanEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .plan(root.getPlan())
                .startDate(GDateTime.of(root.getStartDate()))
                .expiredDate(GDateTime.of(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build();
    }

    @Override
    public AccountPlanEntity toNewEntity(AccountPlanRoot root) {
        return AccountPlanEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .plan(root.getPlan())
                .startDate(GDateTime.of(root.getStartDate()))
                .expiredDate(GDateTime.of(root.getExpiredDate()))
                .isExpired(root.getExpired())
                .promoCode(root.getPromoCode())
                .build();
    }
}
