package az.rock.flyjob.auth.dataAccess.model.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "block_relation", schema = "network")
@Entity(name = "BlockRelationEntity")
public class BlockRelationEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false, updatable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    private UserType targetUserType;

    @Column(nullable = false, updatable = false)
    private UUID targetUserId;

    @Column(name = "description")
    private String description;
}