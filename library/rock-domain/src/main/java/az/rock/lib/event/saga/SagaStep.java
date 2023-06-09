package az.rock.lib.event.saga;

import az.rock.lib.annotation.ValueFace;

@ValueFace
public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}