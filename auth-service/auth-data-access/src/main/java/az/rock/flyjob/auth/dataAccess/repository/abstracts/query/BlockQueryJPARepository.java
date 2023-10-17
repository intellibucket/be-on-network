package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlockQueryJPARepository extends JpaRepository<BlockRelationEntity, UUID> {
    @Query("select b from BlockRelationEntity b where b.userId = :userID" +
            " and b.rowStatus = 'ACTIVE'")
    List<BlockRelationEntity> findMyBlockedList(@Param(value = "userID") UUID userID);

    @Query("select b from BlockRelationEntity b where b.targetUserId = :userID" +
            " and b.rowStatus = 'ACTIVE'")
    List<BlockRelationEntity> findWhoBlockedMe(@Param(value = "userID") UUID userID);

    /**
     * userId - senin , targetUserID - blokladigin
     */
    @Query("SELECT b FROM BlockRelationEntity b where b.userId = :currentUserID" +
            " and b.targetUserId = :targetUserID and b.rowStatus = 'ACTIVE'")
    List<BlockRelationEntity>  isPresentInMyBlockedList(@Param(value = "currentUserID") UUID currentUserId,
                                     @Param(value = "targetUserID") UUID targetUserID);


    @Query("SELECT count(b) > 0 FROM BlockRelationEntity b where b.userId = :currentUserId" +
            "  and b.targetUserId = :targetUserID and b.rowStatus = 'INACTIVE'")
    Boolean unblockTargetUserAgain(@Param(value = "currentUserId") UUID currentUserId,
                                   @Param(value = "targetUserID") UUID targetUserID);

    @Query("SELECT count(b) > 0 FROM BlockRelationEntity b where ((b.userId = :currentUserId  and b.targetUserId = :targetUserID) " +
            " or (b.userId = :targetUserID and b.targetUserId = :currentUserId)) and b.rowStatus = 'ACTIVE'")
    Boolean blockRelationByUsers(@Param(value = "currentUserId") UUID currentUserId,
                                   @Param(value = "targetUserID") UUID targetUserID);
}
