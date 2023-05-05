package az.rock.lib.domain;

import java.time.ZonedDateTime;

public class AggregateRoot<ID> extends RootID<ID> {
    private Long version;
    private ZonedDateTime createdDate;
    private ZonedDateTime modificationDate;

    protected AggregateRoot(ID value) {
        super(value);
    }

    public AggregateRoot(ID id,Long version,ZonedDateTime createdDate,ZonedDateTime modificationDate) {
        super(id);
        this.version = version;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }

    private AggregateRoot(Builder<ID> builder) {
        super(builder.id);
        version = builder.version;
        createdDate = builder.createdDate;
        modificationDate = builder.modificationDate;
    }


    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getModificationDate() {
        return modificationDate;
    }

    public Long getVersion() {
        return version;
    }


    public static final class Builder<ID> {
        private ID id;
        private Long version;
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
