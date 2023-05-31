package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum SyncStatus {
    PROCESSING,
    ON_WAITING,
    COMPLETED,
    FAILED;

    public Boolean isProcessing() {
        return this.equals(PROCESSING);
    }

    public Boolean isOnWaiting() {
        return this.equals(ON_WAITING);
    }

    public Boolean isCompleted() {
        return this.equals(COMPLETED);
    }

    public Boolean isFailed() {
        return this.equals(FAILED);
    }
}
