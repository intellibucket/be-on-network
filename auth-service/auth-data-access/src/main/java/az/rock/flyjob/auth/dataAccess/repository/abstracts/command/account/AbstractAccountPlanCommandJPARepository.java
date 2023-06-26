package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.CustomJPARepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AbstractAccountPlanCommandJPARepository extends CustomJPARepository<AccountPlanEntity> {
}
