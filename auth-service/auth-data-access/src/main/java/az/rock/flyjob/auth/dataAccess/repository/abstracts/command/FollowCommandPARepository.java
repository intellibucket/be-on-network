package az.rock.flyjob.auth.dataAccess.repository.abstracts.command;

import az.rock.flyjob.auth.dataAccess.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FollowCommandPARepository extends JpaRepository<FollowRelationEntity, UUID> {
}
