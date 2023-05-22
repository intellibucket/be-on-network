package az.rock.lib.domain;

import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

import static az.rock.lib.valueObject.DataStatus.*;

public class AggregateRoot<ID> extends SimpleAggregateRoot<ID> {
    private Long version;
    private ProcessStatus processStatus;
    private DataStatus dataStatus;
    private ZonedDateTime createdDate;
    private ZonedDateTime modificationDate;

    protected AggregateRoot(ID value) {
        super(value);
    }

    public AggregateRoot(ID id,
                         Long version,
                         ProcessStatus processStatus,
                         DataStatus dataStatus,
                         ZonedDateTime createdDate,
                         ZonedDateTime modificationDate) {
        super(id);
        this.version = version;
        this.processStatus = processStatus;
        this.dataStatus = dataStatus;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }


    @Override
    public ID getUUID() {
        return super.getUUID();
    }

    public Long getVersion() {
        return version;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public DataStatus getDataStatus() {
        return dataStatus;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getModificationDate() {
        return modificationDate;
    }


    public Boolean sameIdentityAs(AggregateRoot<ID> other) {
        return this.getUUID().equals(other.getUUID());
    }

    public Boolean sameVersionAs(AggregateRoot<ID> other) {
        return this.getVersion().equals(other.getVersion());
    }

    public Boolean sameVersionAs(Long otherVersion) {
        return this.getVersion().equals(otherVersion);
    }

    public Boolean isActive() {
        return this.dataStatus.isActive();
    }

    public Boolean isInactive() {
        return this.dataStatus.isInactive();
    }

    public Boolean isDeleted() {
        return this.dataStatus.isDeleted();
    }


    public Boolean isOnWaiting() {
        return this.processStatus.isOnWaiting();
    }

    public Boolean isProcessing() {
        return this.processStatus.isProcessing();
    }

    public Boolean isCompleted() {
        return this.processStatus.isCompleted();
    }

    public Boolean isFailed() {
        return this.processStatus.isFailed();
    }

    public Boolean isCancelled() {
        return this.processStatus.isCancelled();
    }

    public Boolean isCancelledBySystem() {
        return this.processStatus.isCancelledBySystem();
    }

    public Boolean isCancelling() {
        return this.processStatus.isCancelling();
    }



}
