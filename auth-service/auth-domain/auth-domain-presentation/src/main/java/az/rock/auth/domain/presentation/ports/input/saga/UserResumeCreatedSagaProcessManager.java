package az.rock.auth.domain.presentation.ports.input.saga;

import az.rock.lib.event.EmptyEvent;
import az.rock.lib.event.saga.SagaStep;
import az.rock.lib.event.services.ResumeCreatedEvent;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserResumeCreatedSagaProcessManager implements SagaStep<Void, ResumeCreatedEvent, EmptyEvent> {
    @Override
    public ResumeCreatedEvent process(Void data) {
        return null;
    }

    @Override
    public EmptyEvent rollback(Void data) {
        return null;
    }
}
