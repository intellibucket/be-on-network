package az.rock.flyjob.auth.model.root;

import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.OutboxRoot;
import az.rock.lib.domain.SagaID;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.trx.TrxProcessStatus;

import java.time.ZonedDateTime;

public class UserOutboxRoot extends OutboxRoot<UserOutboxRoot> {
    private final az.rock.lib.valueObject.ProcessStatus processStatus;



    private UserOutboxRoot(Builder builder) {
        super(builder.outboxID,
                builder.sagaId,
                builder.version,
                builder.createdDate,
                builder.lastModifiedDate,
                null,
                builder.type,
                builder.payload);
        processStatus = builder.processStatus;
    }


    public static final class Builder {
        private az.rock.lib.valueObject.ProcessStatus processStatus;

        private OutboxID outboxID;
        private SagaID sagaId;
        private Version version;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private TrxProcessStatus sagaStatus;
        private az.rock.lib.valueObject.OutboxStatus outboxStatus;
        private String type;
        private String payload;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder processStatus(az.rock.lib.valueObject.ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder outboxID(OutboxID val) {
            outboxID = val;
            return this;
        }

        public Builder sagaId(SagaID val) {
            sagaId = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder sagaStatus(TrxProcessStatus val) {
            sagaStatus = val;
            return this;
        }

        public Builder outboxStatus(az.rock.lib.valueObject.OutboxStatus val) {
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

        public UserOutboxRoot build() {
            return new UserOutboxRoot(this);
        }
    }

    public az.rock.lib.valueObject.ProcessStatus getProcessStatus() {
        return processStatus;
    }
}
