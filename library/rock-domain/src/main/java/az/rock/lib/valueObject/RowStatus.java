package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum RowStatus {
    ACTIVE,//When system or user create the record, it will be set to active
    INACTIVE,//When system delete the record, it will be set to inactive

    HIDDEN,//When user hide the record, it will be set to hidden
    DELETED,//When user delete the record, it will be set to deleted
    ROLLBACK;//When system rollback the record, it will be set to rollback

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
