package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;


import az.rock.flyjob.auth.dataAccess.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NetworkQueryJPARepository extends JpaRepository<NetworkRelationEntity, UUID> {
    @Query("select n from NetworkRelationEntity n " +
            "where (n.requestOwnerId = :currentUserID or n.requestTargetId = :currentUserID) " +
            "and n.networkStatus = 'ACCEPTED' and n.rowStatus = 'ACTIVE'")
    List<NetworkRelationEntity> findMyNetworks(UUID currentUserID);

    @Query("select n from NetworkRelationEntity n " +
            "where n.requestTargetId = :currentUserID " +
            "and n.networkStatus = 'PENDING' and n.rowStatus = 'ACTIVE'")
    List<NetworkRelationEntity> findInMyNetworkPendingRequests(UUID currentUserID);

    @Query("select n from NetworkRelationEntity n " +
            "where n.requestOwnerId = :currentUserID " +
            "and n.networkStatus = 'PENDING' and n.rowStatus = 'ACTIVE'")
    List<NetworkRelationEntity> findMyNetworkPendingRequests(UUID currentUserID);

    @Query("select n from NetworkRelationEntity n " +
            "where (n.requestOwnerId = :firstUserID and n.requestTargetId = :secondUserID) " +
            "or (n.requestOwnerId = :secondUserID and n.requestTargetId = :firstUserID)" +
            "and n.rowStatus = 'ACTIVE'")
    NetworkRelationEntity findNetworkRelationByBothOfUserIDs(UUID firstUserID, UUID secondUserID);
}
