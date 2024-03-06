package az.rock.flyjob.js.domain.presentation.ports.output.publisher;

import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public interface AbstractJobSeekerResponseMessagePublisher {
    void publish(String topic, AbstractSagaProcess<?> abstractSagaProcess);
}
