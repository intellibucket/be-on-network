package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.BlockReasonStatus;
import az.rock.lib.valueObject.FollowStatus;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
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
@Table(name = "follow_relation", schema = "network", indexes = {
        @Index(name = "ıdx_following_id", columnList = "followingUserId")
})
@Entity
public class FollowRelationEntity extends BaseEntity {
    private UserType followingUserType;

    private UUID followingUserId;

    private UserType followerUserType;

    private UUID followerUserId;

    private FollowStatus followStatus;

    private BlockReasonStatus blockReasonStatus;
}
