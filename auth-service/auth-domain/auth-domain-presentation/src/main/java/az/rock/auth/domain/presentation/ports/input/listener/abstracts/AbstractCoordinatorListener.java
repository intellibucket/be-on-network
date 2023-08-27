package az.rock.auth.domain.presentation.ports.input.listener.abstracts;


import com.intellibukcet.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibukcet.lib.payload.payload.Payload;
import com.intellibukcet.lib.payload.trx.Saga;

public interface AbstractCoordinatorListener {
    void listenOnSuccess(Saga<AbstractSuccessDomainEvent<? extends Payload>> message);
    void listenOnFail(Saga<AbstractFailDomainEvent<? extends Payload>> message);
}
