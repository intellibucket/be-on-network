package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "network_relation", schema = "network", indexes = {
        @Index(name = "ıdx_networkrelationentity", columnList = "requestTargetId, requestOwnerId, networkStatus")
})
@Entity
public class NetworkRelationEntity extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private UUID requestOwnerId;

    @Column(nullable = false, updatable = false)
    private UUID requestTargetId;

    @Enumerated(EnumType.STRING)
    private NetworkStatus networkStatus;

    @Enumerated(EnumType.STRING)
    private BlockReasonStatus blockReasonStatus;

}
