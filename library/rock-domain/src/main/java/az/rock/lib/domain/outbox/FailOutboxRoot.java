package az.rock.lib.domain.outbox;

import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.Version;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public abstract class FailOutboxRoot<D> extends RootID<OutboxID> {
    private Boolean isActive;
    private TransactionID transactionId;
    private Version version;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
    private OutboxStatus trxStatus;
    private String topic;
    private String process;
    private String step;
    private String event;
    private Boolean mustBeRetryableStep;
}
