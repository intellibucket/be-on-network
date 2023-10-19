package az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts;

import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.Saga;

public interface AbstractJobSeekerCreatedEventListenerAdapter {
    void consume(Saga<JobSeekerCreatedEvent> eventSaga);
}
