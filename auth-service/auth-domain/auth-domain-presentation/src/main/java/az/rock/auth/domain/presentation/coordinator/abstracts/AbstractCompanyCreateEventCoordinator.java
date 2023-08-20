package az.rock.auth.domain.presentation.coordinator.abstracts;

import az.rock.lib.event.AbstractEventCoordinator;
import az.rock.lib.event.impl.concretes.auth.create.CompanyCreatedEvent;

public abstract class AbstractCompanyCreateEventCoordinator extends AbstractEventCoordinator<CompanyCreatedEvent> {
}
