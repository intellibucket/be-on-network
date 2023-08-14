package az.rock.auth.domain.presentation.ports.input.listener.abstracts;

import az.rock.lib.event.impl.abstracts.AbstractFailDomainEvent;
import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.trx.Saga;
import az.rock.lib.event.payload.Payload;

public interface AbstractCoordinatorListener {
    void listenOnSuccess(Saga<AbstractSuccessDomainEvent<? extends Payload>> message);
    void listenOnFail(Saga<AbstractFailDomainEvent<? extends Payload>> message);
}
