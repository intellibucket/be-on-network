package az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts;

import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;

public interface AbstractJobSeekerCreatedEventListenerAdapter {
    void consume(Saga<JobSeekerCreatedEvent> eventSaga);
}
