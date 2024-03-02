package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum RowStatus {
    ACTIVE,
    INACTIVE,
    DELETED,
    ROLLBACK;

    public Boolean isActive() {
        return this.equals(ACTIVE);
    }

    public Boolean isInactive() {
        return this.equals(INACTIVE);
    }

    public Boolean isDeleted() {
        return this.equals(DELETED);
    }

    public Boolean isRollback() {
        return this.equals(ROLLBACK);
    }


}
