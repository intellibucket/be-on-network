package az.rock.auth.domain.presentation.ports.input.listener.abstracts;


import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public interface AbstractCoordinatorListener {
    void listenOnSuccess(AbstractSagaProcess<AbstractSuccessDomainEvent<? extends Payload>> message);

    void listenOnFail(AbstractSagaProcess<AbstractFailDomainEvent<? extends Payload>> message);
}
