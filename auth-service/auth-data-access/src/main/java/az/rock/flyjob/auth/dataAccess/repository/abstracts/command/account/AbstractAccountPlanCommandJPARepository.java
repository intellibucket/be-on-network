package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.CustomCommandJPARepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AbstractAccountPlanCommandJPARepository extends CustomCommandJPARepository<AccountPlanEntity> {
}
