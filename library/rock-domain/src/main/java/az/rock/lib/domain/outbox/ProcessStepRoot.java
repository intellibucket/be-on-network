package az.rock.lib.domain.outbox;

import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.valueObject.Version;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class ProcessStepRoot extends RootID<OutboxID> {
    private Boolean isActive;
    private TransactionID transactionId;
    private Version version;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
    private String process;
    private String step;
    private Boolean isSuccessful;

    private ProcessStepRoot(Builder builder) {
        super(builder.uuid);
        setIsActive(builder.isActive);
        setTransactionId(builder.transactionId);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        setProcess(builder.process);
        setStep(builder.step);
        setIsSuccessful(builder.isSuccessful);
    }


    public static final class Builder {
        private OutboxID uuid;
        private Boolean isActive;
        private TransactionID transactionId;
        private Version version;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private String process;
        private String step;
        private Boolean isSuccessful;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(OutboxID val) {
            uuid = val;
            return this;
        }

        public Builder isActive(Boolean val) {
            isActive = val;
            return this;
        }

        public Builder transactionId(TransactionID val) {
            transactionId = val;
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

        public Builder process(String val) {
            process = val;
            return this;
        }

        public Builder step(String val) {
            step = val;
            return this;
        }

        public Builder isSuccessful(Boolean val) {
            isSuccessful = val;
            return this;
        }

        public ProcessStepRoot build() {
            return new ProcessStepRoot(this);
        }
    }
}
