package az.rock.lib.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class RootID <ID> {
    private ID uuid;

    public RootID() {}

    public RootID(ID value) {
        this.uuid = value;
    }

    public static <ID> RootID<ID> of(ID value){
        return new RootID<>(value);
    }

    public static RootID<UUID> of(){
        return new RootID<>(UUID.randomUUID());
    }

    @JsonIgnore
    public ID getRootID() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootID<?> baseId = (RootID<?>) o;
        return uuid.equals(baseId.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @JsonIgnore
    public Boolean isEmpty(){
        return this.uuid == null;
    }

    public void setUuid(ID uuid) {
        this.uuid = uuid;
    }
}
