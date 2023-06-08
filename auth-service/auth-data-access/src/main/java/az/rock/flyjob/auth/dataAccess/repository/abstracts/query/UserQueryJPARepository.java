package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.valueObject.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserQueryJPARepository  {
    UserType findUserTypeById(UUID userId);

    UserEntity findById(UUID userId);

    UserEntity findByIdAndActive(UUID userId);
}
