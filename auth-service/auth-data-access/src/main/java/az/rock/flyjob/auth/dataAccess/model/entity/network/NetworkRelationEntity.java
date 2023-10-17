package az.rock.flyjob.auth.dataAccess.model.entity.network;

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

    private NetworkRelationEntity(Builder builder) {
        setRequestOwnerId(builder.requestOwnerId);
        setRequestTargetId(builder.requestTargetId);
        setNetworkStatus(builder.networkStatus);
        setBlockReasonStatus(builder.blockReasonStatus);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UUID requestOwnerId;
        private UUID requestTargetId;
        private NetworkStatus networkStatus;
        private BlockReasonStatus blockReasonStatus;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder requestOwnerId(UUID val) {
            requestOwnerId = val;
            return this;
        }

        public Builder requestTargetId(UUID val) {
            requestTargetId = val;
            return this;
        }

        public Builder networkStatus(NetworkStatus val) {
            networkStatus = val;
            return this;
        }

        public Builder blockReasonStatus(BlockReasonStatus val) {
            blockReasonStatus = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public NetworkRelationEntity build() {
            return new NetworkRelationEntity(this);
        }
    }
}
