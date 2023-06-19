package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.BaseCustomRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface AbstractAccountPlanCommandJPARepository extends BaseCustomRepository<AccountPlanEntity> {
}
