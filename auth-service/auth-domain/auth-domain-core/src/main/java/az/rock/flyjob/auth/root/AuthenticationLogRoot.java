package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.AuthenticationLogID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AuthenticationLogRoot extends AggregateRoot<AuthenticationLogID> {
    private final DeviceRoot device;
    private final UUID deviceToken;

    public AuthenticationLogRoot(AuthenticationLogID authenticationLogID,
                                 Long version,
                                 ProcessStatus processStatus,
                                 DataStatus dataStatus,
                                 ZonedDateTime createdDate,
                                 ZonedDateTime modificationDate,
                                 DeviceRoot device,
                                 UUID deviceToken) {
        super(authenticationLogID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.device = device;
        this.deviceToken = deviceToken;
    }

    private AuthenticationLogRoot(Builder builder) {
        super(builder.authenticationLogID, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        device = builder.device;
        deviceToken = builder.deviceToken;
    }


    public DeviceRoot getDevice() {
        return device;
    }

    public UUID getDeviceToken() {
        return deviceToken;
    }

    public static final class Builder {
        private AuthenticationLogID authenticationLogID;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;

        private DeviceRoot device;
        private UUID deviceToken;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder authenticationLogID(AuthenticationLogID val) {
            authenticationLogID = val;
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }


        public Builder device(DeviceRoot val) {
            device = val;
            return this;
        }

        public Builder deviceToken(UUID val) {
            deviceToken = val;
            return this;
        }

        public AuthenticationLogRoot build() {
            return new AuthenticationLogRoot(this);
        }
    }
}