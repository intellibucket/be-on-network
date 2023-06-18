package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum ProcessStatus {
    ON_WAITING_FOR_PAYMENT,
    ON_WAITING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED,
    CANCELLED_BY_SYSTEM,
    CANCELLING;

    public Boolean isOnWaiting() {
        return this.equals(ON_WAITING);
    }

    public Boolean isProcessing() {
        return this.equals(PROCESSING);
    }

    public Boolean isCompleted() {
        return this.equals(COMPLETED);
    }

    public Boolean isFailed() {
        return this.equals(FAILED);
    }

    public Boolean isCancelled() {
        return this.equals(CANCELLED);
    }

    public Boolean isCancelledBySystem() {
        return this.equals(CANCELLED_BY_SYSTEM);
    }

    public Boolean isCancelling() {
        return this.equals(CANCELLING);
    }

    public static ProcessStatus of(String processStatus) {
        return ProcessStatus.valueOf(processStatus);
    }

    public static ProcessStatus of(ProcessStatus processStatus) {
        return processStatus;
    }

}
