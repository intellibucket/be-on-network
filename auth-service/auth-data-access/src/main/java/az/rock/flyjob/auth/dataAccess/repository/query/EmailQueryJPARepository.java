package az.rock.flyjob.auth.dataAccess.repository.query;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailQueryJPARepository extends JpaRepository<EmailEntity, UUID> {

    @Query("SELECT e FROM EmailEntity e WHERE e.user.uuid = :userID AND e.uuid = :emailID")
    EmailEntity findByUserIDAndEmailID(@Param(value = "userID") UUID userID,@Param(value = "emailID") UUID emailID);

    @Query("SELECT e FROM EmailEntity e WHERE e.uuid = :emailID")
    EmailEntity findByID(@Param(value = "emailID") UUID emailID);

    @Query("SELECT e FROM EmailEntity e WHERE e.user.uuid = :userID")
    List<EmailEntity> findAllByUserID(@Param(value = "userID") UUID userID);

    @Query("SELECT e.uuid FROM EmailEntity e WHERE e.user.uuid = :userID")
    List<UUID> findAllIDByUserID(@Param(value = "userID") UUID userID);


}
