package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserQueryJPARepository extends JpaRepository<UserEntity,UUID> {

    @Query("SELECT row.userType FROM UserEntity row " +
            "WHERE (:userId = row.uuid) and (row.rowStatus = 'ACTIVE')")
    UserType findUserTypeById(@Param(value = "userId") UUID userId);

    @Query("SELECT row FROM UserEntity row " +
            "WHERE (:userId = row.uuid) and (row.rowStatus = 'ACTIVE') ")
    UserEntity findByUUID(@Param(value = "userId") UUID userId);

    @Query("SELECT row.key FROM UserEntity row " +
            "WHERE (:uuid = row.uuid) and (row.rowStatus = 'ACTIVE')")
    UUID findKeyByUUID(@Param(value = "uuid") UUID uuid);

    @Query("SELECT row.username FROM UserEntity row " +
            "WHERE (:uuid = row.uuid) and (row.rowStatus = 'ACTIVE')")
    String findUsernameByUUID(UUID uuid);

    @Query("SELECT row FROM UserEntity row " +
            "WHERE (:username = row.username) and (row.rowStatus = 'ACTIVE')")
    UserEntity findByUsername(String username);

    @Query("SELECT row.accessModifier FROM UserEntity row " +
            "WHERE (:userID = row.uuid) and (row.rowStatus = 'ACTIVE')")
    AccessModifier findAccessModifierByUUID(UUID userID);

}
