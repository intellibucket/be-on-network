package az.rock.lib.valueObject;

import java.util.Objects;

public class RootID <ID> {
    private final ID value;

    protected RootID(ID value) {
        this.value = value;
    }

    public static <ID> RootID<ID> of(ID value){
        return new RootID<>(value);
    }

    public ID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootID<?> baseId = (RootID<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
