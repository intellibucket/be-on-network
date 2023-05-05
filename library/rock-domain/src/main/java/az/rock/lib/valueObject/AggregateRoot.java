package az.rock.lib.valueObject;

import java.time.ZonedDateTime;

public class AggregateRoot<ID> extends RootID<ID>{
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


    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getModificationDate() {
        return modificationDate;
    }

    public Long getVersion() {
        return version;
    }



}
