package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.BlockReasonStatus;
import az.rock.lib.valueObject.FollowStatus;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private UserType followingUserType;

    @Column(nullable = false, updatable = false)
    private UUID followingUserId;

    @Enumerated(EnumType.STRING)
    private UserType followerUserType;

    @Column(nullable = false, updatable = false)
    private UUID followerUserId;

    @Enumerated(EnumType.STRING)
    private FollowStatus followStatus;

    @Enumerated(EnumType.STRING)
    private BlockReasonStatus blockReasonStatus;
}
