package az.rock.flyjob.auth.dataAccess.repository.account;

import az.rock.flyjob.auth.dataAccess.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountEntity, UUID> {
}
