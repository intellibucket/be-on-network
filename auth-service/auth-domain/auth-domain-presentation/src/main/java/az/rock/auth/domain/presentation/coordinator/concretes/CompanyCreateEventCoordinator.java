package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
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
