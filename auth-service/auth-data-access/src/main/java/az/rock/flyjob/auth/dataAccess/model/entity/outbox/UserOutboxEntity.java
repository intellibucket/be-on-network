package az.rock.flyjob.auth.dataAccess.model.entity.outbox;

import az.rock.lib.domain.OutboxEntity;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "user_outbox", schema = "outbox")
@Entity
public class UserOutboxEntity extends OutboxEntity {

    @Enumerated(EnumType.STRING)
    private ProcessStatus processStatus;

    private UserOutboxEntity(Builder builder) {
        setProcessStatus(builder.processStatus);
        setUuid(builder.uuid);
        setSagaId(builder.sagaId);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        setOutboxStatus(builder.outboxStatus);
        setType(builder.type);
        setPayload(builder.payload);
    }


    public static final class Builder {
        private ProcessStatus processStatus;
        private UUID uuid;
        private UUID sagaId;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private OutboxStatus outboxStatus;
        private String type;
        private String payload;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder sagaId(UUID val) {
            sagaId = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
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

        public Builder outboxStatus(OutboxStatus val) {
            outboxStatus = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder payload(String val) {
            payload = val;
            return this;
        }

        public UserOutboxEntity build() {
            return new UserOutboxEntity(this);
        }
    }
}
