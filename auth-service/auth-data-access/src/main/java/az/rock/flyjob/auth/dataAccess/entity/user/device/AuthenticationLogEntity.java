package az.rock.flyjob.auth.dataAccess.entity.user.device;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authentication_logs", schema = "auth")
@Entity(name = "AuthenticationLogEntity")
public class AuthenticationLogEntity extends BaseEntity {
    @ManyToOne
    private DeviceEntity device;

    @Column(name = "device_token", nullable = false, updatable = false)
    private UUID deviceToken;

    private AuthenticationLogEntity(Builder builder) {
        setDevice(builder.device);
        setDeviceToken(builder.deviceToken);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setDataStatus(builder.dataStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private DeviceEntity device;
        private UUID deviceToken;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder device(DeviceEntity val) {
            device = val;
            return this;
        }

        public Builder deviceToken(UUID val) {
            deviceToken = val;
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

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
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

        public AuthenticationLogEntity build() {
            return new AuthenticationLogEntity(this);
        }
    }
}
