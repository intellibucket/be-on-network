package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowQueryJPARepository extends JpaRepository<FollowRelationEntity,UUID> {
    @Query("select f from FollowRelationEntity f where f.followedUserId = ?1" +
            "and f.followStatus = 'ACCEPTED' and f.rowStatus = 'ACTIVE'")
    List<FollowRelationEntity> findAllMyFollowers(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followingUserId = ?1" +
            "and f.followStatus = 'ACCEPTED' and f.rowStatus = 'ACTIVE'")
    List<FollowRelationEntity> findAllMyFollowings(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followingUserId = ?1" +
            "and f.followStatus = 'PENDING' and f.rowStatus = 'ACTIVE'")
    List<FollowRelationEntity> findAllInMyPendingFollowRequests(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followedUserId = ?1" +
            "and f.followStatus = 'PENDING' and f.rowStatus = 'ACTIVE'")
    List<FollowRelationEntity> findAllMyPendingFollowRequests(UUID absoluteID);
}
