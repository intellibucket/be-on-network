package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum DataStatus {
    ACTIVE,
    INACTIVE,
    DELETED,
    FAILED,
    FROZEN,
    ON_PROCESSING,
    ON_WAITING;

    public Boolean isActive() {
        return this.equals(ACTIVE);
    }

    public Boolean isInactive() {
        return this.equals(INACTIVE);
    }

    public Boolean isDeleted() {
        return this.equals(DELETED);
    }

    public Boolean isFailed() {
        return this.equals(FAILED);
    }

    public Boolean isFrozen() {
        return this.equals(FROZEN);
    }

    public Boolean isOnProcessing() {
        return this.equals(ON_PROCESSING);
    }

    public Boolean isOnWaiting() {
        return this.equals(ON_WAITING);
    }


}
