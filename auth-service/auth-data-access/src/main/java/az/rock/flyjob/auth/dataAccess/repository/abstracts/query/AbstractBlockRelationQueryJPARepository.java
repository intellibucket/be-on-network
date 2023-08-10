package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractBlockRelationQueryJPARepository extends JpaRepository<BlockRelationEntity, UUID> {
}
