package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum DataStatus {
    ACTIVE,
    INACTIVE,
    DELETED;
    public Boolean isActive() {
        return this.equals(ACTIVE);
    }

    public Boolean isInactive() {
        return this.equals(INACTIVE);
    }

    public Boolean isDeleted() {
        return this.equals(DELETED);
    }

}
