package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.entity.network.FollowRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowQueryJPARepository extends JpaRepository<FollowRelationEntity,UUID> {
    @Query("select f from FollowRelationEntity f where f.followedUserId = ?1" +
            "and f.followStatus = 'ACCEPTED'")
    List<FollowRelationEntity> findAllMyFollowers(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followingUserId = ?1" +
            "and f.followStatus = 'ACCEPTED'")
    List<FollowRelationEntity> findAllMyFollowings(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followingUserId = ?1" +
            "and f.followStatus = 'PENDING'")
    List<FollowRelationEntity> findAllInMyPendingFollowRequests(UUID absoluteID);

    @Query("select f from FollowRelationEntity f where f.followedUserId = ?1" +
            "and f.followStatus = 'PENDING'")
    List<FollowRelationEntity> findAllMyPendingFollowRequests(UUID absoluteID);
}
