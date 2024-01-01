package az.rock.flyjob.js.domain.presentation.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.coordinator.abstracts.AbstractResumeResponsiveEventResponseCoordinator;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;

public class ResumeResponsiveEventResponseCoordinator extends AbstractResumeResponsiveEventResponseCoordinator {

    @Override
    protected String getTopic() {
        return null;
    }

    @Override
    protected void onError(AbstractSagaProcess sagaProcess, Throwable throwable) {

    }

    @Override
    protected void onFail(AbstractSagaProcess sagaProcess, JDomainException exception) {

    }

    @Override
    public void execute(SagaStartedProcess sagaProcess) throws JDomainException {

    }
}
