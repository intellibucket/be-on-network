package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.BlockReasonStatus;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "follow_relation", schema = "network")
@Entity
public class FollowRelationEntity extends BaseEntity {
    private UserType requestOwnerType;

    private UUID requestOwnerId;

    private UserType requestTargetType;

    private UUID requestTargetId;

    private BlockReasonStatus blockReasonStatus;
}
