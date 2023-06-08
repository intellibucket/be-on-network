package az.rock.flyjob.auth.dataAccess.repository.abstracts;

import az.rock.flyjob.auth.dataAccess.entity.user.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneNumberJPARepository extends JpaRepository<PhoneNumberEntity, UUID> {
}
