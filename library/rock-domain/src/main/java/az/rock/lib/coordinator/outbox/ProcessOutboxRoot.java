package az.rock.lib.coordinator.outbox;

import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.trx.TrxProcessStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class ProcessOutboxRoot extends RootID<OutboxID> {
    private Boolean isActive;
    private TransactionID transactionId;
    private Version version;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
    private TrxProcessStatus trxStatus;
    private String topic;
    private String process;
    private String step;
    private String event;
    private Boolean mustBeRetryableStep;

    private ProcessOutboxRoot(Builder builder) {
        super(builder.uuid);
        setIsActive(builder.isActive);
        setTransactionId(builder.transactionId);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        setTrxStatus(builder.trxStatus);
        setTopic(builder.topic);
        setProcess(builder.process);
        setStep(builder.step);
        setEvent(builder.event);
        setMustBeRetryableStep(builder.mustBeRetryableStep);
    }


    public static final class Builder {
        private OutboxID uuid;
        private Boolean isActive;
        private TransactionID transactionId;
        private Version version;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private TrxProcessStatus trxStatus;
        private String topic;
        private String process;
        private String step;
        private String event;
        private Boolean mustBeRetryableStep;

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

        public Builder trxStatus(TrxProcessStatus val) {
            trxStatus = val;
            return this;
        }

        public Builder topic(String val) {
            topic = val;
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

        public Builder event(String val) {
            event = val;
            return this;
        }

        public Builder mustBeRetryableStep(Boolean val) {
            mustBeRetryableStep = val;
            return this;
        }

        public ProcessOutboxRoot build() {
            return new ProcessOutboxRoot(this);
        }
    }
}
