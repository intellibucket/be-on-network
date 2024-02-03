package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractCompanyCreateEventCoordinator extends AbstractUserCreateEventCoordinator<CompanyCreatedEvent> {
    public AbstractCompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher,
                                                 AbstractOutboxInputPort outboxProcess) {
        super(userMessagePublisher, outboxProcess);
    }

    @Override
    public List<String> allSteps() {
        return Arrays.stream(CompanyRegistrationSteps.values()).map(Enum::name).toList();
    }
}
