package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;


import az.rock.flyjob.auth.dataAccess.entity.network.NetworkRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NetworkQueryJPARepository extends JpaRepository<NetworkRelationEntity, UUID> {
    List<NetworkRelationEntity> findMyNetworks(UUID currentUserID);
}
