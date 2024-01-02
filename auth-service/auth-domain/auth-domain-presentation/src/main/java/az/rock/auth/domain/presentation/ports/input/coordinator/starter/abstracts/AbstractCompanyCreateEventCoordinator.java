package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;

public abstract class AbstractCompanyCreateEventCoordinator extends AbstractUserCreateEventCoordinator<CompanyCreatedEvent> {
    public AbstractCompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher) {
        super(userMessagePublisher);
    }
}
