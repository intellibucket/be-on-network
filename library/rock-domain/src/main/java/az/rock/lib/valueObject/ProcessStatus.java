package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum ProcessStatus {
    ON_WAITING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED,
    CANCELLED_BY_SYSTEM,
    CANCELLING;
}
