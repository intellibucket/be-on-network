package az.rock.lib.domain;

import java.util.Objects;

public class RootID <ID> {
    private final ID uuid;

    protected RootID(ID value) {
        this.uuid = value;
    }

    public static <ID> RootID<ID> of(ID value){
        return new RootID<>(value);
    }

    public ID getUUID() {
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

    public Boolean isNull(){
        return uuid == null;
    }
}
