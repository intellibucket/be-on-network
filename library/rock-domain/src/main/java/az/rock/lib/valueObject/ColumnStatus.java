package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum ColumnStatus {
    ACTIVE,
    INACTIVE,
    DELETED,
    FAILED,
    FROZEN,
    ON_PROCESSING,
    ON_WAITING;
}
