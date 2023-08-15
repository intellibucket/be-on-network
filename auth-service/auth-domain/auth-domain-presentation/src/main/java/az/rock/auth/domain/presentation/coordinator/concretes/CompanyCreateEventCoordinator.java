package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.flyjob.auth.event.user.CompanyCreatedEvent;
import az.rock.lib.event.AbstractDomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {


    @Override
    protected void proceed(CompanyCreatedEvent event) {

    }

    @Override
    protected void onError(Exception exception, CompanyCreatedEvent event) {

    }


    @Override
    public void onFail(AbstractDomainEvent<?> domainEvent) {

    }

    @Override
    public void onSuccess(AbstractDomainEvent<?> domainEvent) {

    }
}
