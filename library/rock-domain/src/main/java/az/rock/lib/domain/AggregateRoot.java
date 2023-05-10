package az.rock.lib.domain;

import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

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

    private AggregateRoot(Builder<ID> builder) {
        super(builder.id);
        this.version = builder.version;
        this.processStatus = builder.processStatus;
        this.dataStatus = builder.dataStatus;
        this.createdDate = builder.createdDate;
        this.modificationDate = builder.modificationDate;
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


    public static final class Builder<ID> {
        private ID id;
        private Long version;

        private ProcessStatus processStatus;

        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;

        public Builder(ID id) {
            this.id = id;
        }

        public Builder<ID> id(ID val) {
            this.id = val;
            return this;
        }

        public Builder<ID> version(Long val) {
            version = val;
            return this;
        }

        public Builder<ID> processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder<ID> dataStatus(DataStatus val) {
            dataStatus = val;
            return this;
        }

        public Builder<ID> createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder<ID> modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public AggregateRoot<ID> build() {
            return new AggregateRoot<ID>(this);
        }
    }
}
