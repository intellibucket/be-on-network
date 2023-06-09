package az.rock.lib.event.saga;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum SagaStatus {
    STARTED, FAILED, SUCCEEDED, PROCESSING, COMPENSATING, COMPENSATED
}
