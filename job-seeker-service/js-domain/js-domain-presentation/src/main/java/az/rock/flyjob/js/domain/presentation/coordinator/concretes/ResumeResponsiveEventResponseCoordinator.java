package az.rock.flyjob.js.domain.presentation.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.coordinator.abstracts.AbstractResumeResponsiveEventResponseCoordinator;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public class ResumeResponsiveEventResponseCoordinator extends AbstractResumeResponsiveEventResponseCoordinator {

    @Override
    protected void onError(AbstractSagaProcess sagaProcess, Throwable throwable) {

    }

    @Override
    public void apply(AbstractSagaProcess sagaProcess) throws JDomainException {

    }

    @Override
    public void onFail(AbstractSagaProcess sagaProcess) {

    }

    @Override
    public void onFail(AbstractSagaProcess sagaProcess, JDomainException exception) {

    }
}
