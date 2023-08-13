package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.flyjob.auth.event.user.CompanyCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {

    @Override
    protected void proceed(CompanyCreatedEvent event) {

    }

    @Override
    public void error() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onSuccess() {

    }
}
