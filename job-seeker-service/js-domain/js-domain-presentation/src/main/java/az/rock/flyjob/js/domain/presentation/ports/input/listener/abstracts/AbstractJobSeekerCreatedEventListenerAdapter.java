package az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts;

import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.trx.Saga;

public interface AbstractJobSeekerCreatedEventListenerAdapter {
    void consume(Saga<JobSeekerCreatedEvent> eventSaga);
}
