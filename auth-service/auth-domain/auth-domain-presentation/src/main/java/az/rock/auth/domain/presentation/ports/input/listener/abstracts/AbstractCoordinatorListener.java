package az.rock.auth.domain.presentation.ports.input.listener.abstracts;


import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.SagaProcess;

public interface AbstractCoordinatorListener {
    void listenOnSuccess(SagaProcess<AbstractSuccessDomainEvent<? extends Payload>> message);

    void listenOnFail(SagaProcess<AbstractFailDomainEvent<? extends Payload>> message);
}
