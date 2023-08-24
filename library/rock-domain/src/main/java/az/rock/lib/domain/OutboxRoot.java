package az.rock.lib.domain;

import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public abstract class OutboxRoot<D>  extends RootID<OutboxID> {

    private SagaID sagaId;

    private Version version;

    private ZonedDateTime createdDate;

    private ZonedDateTime lastModifiedDate;

    private State sagaStatus;

    private OutboxStatus outboxStatus;

    private String type;

    private String payload;

    public OutboxRoot(OutboxID value,
                      SagaID sagaId,
                      Version version,
                      ZonedDateTime createdDate,
                      ZonedDateTime lastModifiedDate,
                      OutboxStatus outboxStatus,
                      String type,
                      String payload) {
        super(value);
        this.sagaId = sagaId;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.sagaStatus = sagaStatus;
        this.outboxStatus = outboxStatus;
        this.type = type;
        this.payload = payload;
    }


    public SagaID getSagaId() {
        return sagaId;
    }

    public Version getVersion() {
        return version;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public State getSagaStatus() {
        return sagaStatus;
    }

    public OutboxStatus getOutboxStatus() {
        return outboxStatus;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }
}
