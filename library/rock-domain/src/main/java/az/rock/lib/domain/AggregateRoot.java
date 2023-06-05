package az.rock.lib.domain;

import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class AggregateRoot<ID> extends SimpleAggregateRoot<ID> implements NullValueReference<AggregateRoot<ID>> {

    private Version version;
    private ProcessStatus processStatus;
    private RowStatus rowStatus;
    private ZonedDateTime createdDate;
    private ZonedDateTime modificationDate;

    public Boolean isNull() {
        return true;
    }

    protected AggregateRoot(ID value) {
        super(value);
    }

    public AggregateRoot(ID id,
                         Version version,
                         ProcessStatus processStatus,
                         RowStatus rowStatus,
                         ZonedDateTime createdDate,
                         ZonedDateTime modificationDate) {
        super(id);
        this.version = version;
        this.processStatus = processStatus;
        this.rowStatus = rowStatus;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }

    public AggregateRoot(ID id,
                         Long version,
                         ProcessStatus processStatus,
                         RowStatus rowStatus,
                         ZonedDateTime createdDate,
                         ZonedDateTime modificationDate) {
        super(id);
        this.version = new Version(version);
        this.processStatus = processStatus;
        this.rowStatus = rowStatus;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }

    public AggregateRoot() {
        super(null);
    }


    @Override
    public ID getUUID() {
        return super.getUUID();
    }

    public Long getVersionValue() {
        return version.value();
    }

    public Version getVersion() {
        return version;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public RowStatus getRowStatus() {
        return rowStatus;
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
        return this.getVersionValue().equals(other.getVersionValue());
    }

    public Boolean sameVersionAs(Long otherVersion) {
        return this.getVersionValue().equals(otherVersion);
    }

    public Boolean isActive() {
        return this.rowStatus.isActive();
    }

    public Boolean isInactive() {
        return this.rowStatus.isInactive();
    }

    public Boolean isDeleted() {
        return this.rowStatus.isDeleted();
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
