package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
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
        @Index(name = "ıdx_networkrelationentity", columnList = "networkStatus")
})
@Entity
public class NetworkRelationEntity extends BaseEntity {

    private UUID requestOwnerId;

    private UUID requestTargetId;

    private NetworkStatus networkStatus;

    private BlockReasonStatus blockReasonStatus;

}
