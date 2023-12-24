package az.rock.lib.domain;

import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;

public class AggregateRoot<ID> extends SimpleAggregateRoot<ID> implements NullValueReference<AggregateRoot<ID>> {

    private Version version;
    private ProcessStatus processStatus;
    private RowStatus rowStatus;
    private ZonedDateTime createdDate;
    private ZonedDateTime modificationDate;

    @JsonIgnore
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
    @JsonIgnore
    public ID getRootID() {
        return super.getRootID();
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


    @JsonIgnore
    public Boolean sameIdentityAs(AggregateRoot<ID> other) {
        return this.getRootID().equals(other.getRootID());
    }

    @JsonIgnore
    public Boolean sameVersionAs(AggregateRoot<ID> other) {
        return this.getVersionValue().equals(other.getVersionValue());
    }

    @JsonIgnore
    public Boolean sameVersionAs(Long otherVersion) {
        return this.getVersionValue().equals(otherVersion);
    }

    @JsonIgnore
    public Boolean isActive() {
        return this.rowStatus.isActive() && this.processStatus.isOnWaiting();
    }

    @JsonIgnore
    public Boolean isInactive() {
        return this.rowStatus.isInactive();
    }

    @JsonIgnore
    public Boolean isDeleted() {
        return this.rowStatus.isDeleted();
    }


    @JsonIgnore
    public Boolean isOnWaiting() {
        return this.processStatus.isOnWaiting();
    }

    @JsonIgnore
    public Boolean isProcessing() {
        return this.processStatus.isProcessing();
    }

    @JsonIgnore
    public Boolean isCompleted() {
        return this.processStatus.isCompleted();
    }

    @JsonIgnore
    public Boolean isFailed() {
        return this.processStatus.isFailed();
    }

    @JsonIgnore
    public Boolean isCancelled() {
        return this.processStatus.isCancelled();
    }

    @JsonIgnore
    public Boolean isCancelledBySystem() {
        return this.processStatus.isCancelledBySystem();
    }

    @JsonIgnore
    public Boolean isCancelling() {
        return this.processStatus.isCancelling();
    }

    @JsonIgnore
    public void inActive(){
        this.rowStatus = RowStatus.INACTIVE;
    }

    @JsonIgnore
    public void delete(){
        this.rowStatus = RowStatus.DELETED;
    }
}
