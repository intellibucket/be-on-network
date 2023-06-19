package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountPlanCommandJPARepository extends JpaRepository<AccountPlanEntity, UUID> {

}
