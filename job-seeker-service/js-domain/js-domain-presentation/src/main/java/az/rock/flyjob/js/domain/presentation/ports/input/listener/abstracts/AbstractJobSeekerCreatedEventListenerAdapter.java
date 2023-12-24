package az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts;

import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public interface AbstractJobSeekerCreatedEventListenerAdapter {
    void consume(AbstractSagaProcess<JobSeekerCreatedEvent> eventSagaProcess);
}
