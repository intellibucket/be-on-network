package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;

public interface UserQueryJPARepository  {
    UserType findUserTypeById(UUID userId);

    UserEntity findById(UUID userId);

    UserEntity findByIdAndActiveRowStatus(UUID userId);

    UserEntity findByEmail(String email);
}
