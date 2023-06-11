package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;


import az.rock.flyjob.auth.dataAccess.entity.network.NetworkRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NetworkQueryJPARepository extends JpaRepository<NetworkRelationEntity, UUID> {
    @Query("select n from NetworkRelationEntity n " +
            "where (n.requestOwnerId = :currentUserID or n.requestTargetId = :currentUserID) " +
            "and n.networkStatus = 'ACCEPTED'")
    List<NetworkRelationEntity> findMyNetworks(UUID currentUserID);

    @Query("select n from NetworkRelationEntity n " +
            "where n.requestTargetId = :currentUserID " +
            "and n.networkStatus = 'PENDING'")
    List<NetworkRelationEntity> findInMyNetworkPendingRequests(UUID currentUserID);
}
