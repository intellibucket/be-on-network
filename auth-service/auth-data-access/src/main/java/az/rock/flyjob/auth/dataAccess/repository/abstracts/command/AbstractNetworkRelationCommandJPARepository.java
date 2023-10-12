package az.rock.flyjob.auth.dataAccess.repository.abstracts.command;

import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.CustomCommandJPARepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface AbstractNetworkRelationCommandJPARepository extends CustomCommandJPARepository<NetworkRelationEntity> {
}
