package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.lib.event.impl.abstracts.AbstractFailDomainEvent;
import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.impl.concretes.auth.create.CompanyCreatedEvent;
import az.rock.lib.event.payload.Payload;
import az.rock.lib.event.trx.Saga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {


    @Override
    protected void proceed(Saga<CompanyCreatedEvent> saga) {

    }

    @Override
    protected void onError(Exception exception, Saga<CompanyCreatedEvent> saga) {

    }

    @Override
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(Saga<F> saga) {

    }

    @Override
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(Saga<S> saga) {

    }
}
