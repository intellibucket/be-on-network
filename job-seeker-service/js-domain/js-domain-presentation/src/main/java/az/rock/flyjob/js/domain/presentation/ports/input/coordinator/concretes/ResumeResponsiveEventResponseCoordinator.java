package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts.AbstractResumeResponsiveEventResponseCoordinator;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;

import java.util.function.BiConsumer;

public class ResumeResponsiveEventResponseCoordinator extends AbstractResumeResponsiveEventResponseCoordinator {

    @Override
    protected String getTopic() {
        return null;
    }

    @Override
    protected Enum<?> getStep() {
        return null;
    }

    @Override
    protected BiConsumer<String, AbstractSagaProcess<?>> consumer() {
        return null;
    }

    @Override
    protected void onError(AbstractSagaProcess sagaProcess, Throwable throwable) {

    }

    @Override
    protected void onFail(AbstractSagaProcess sagaProcess, JDomainException exception) {

    }

    @Override
    public AbstractSuccessDomainEvent<?> execute(SagaStartedProcess sagaProcess) throws JDomainException {

        return null;
    }
}
