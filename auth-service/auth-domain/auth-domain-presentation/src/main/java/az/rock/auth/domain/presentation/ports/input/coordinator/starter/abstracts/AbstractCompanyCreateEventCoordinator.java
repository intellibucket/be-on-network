package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.coordinator.ProcessProperty;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;

import java.util.Arrays;

public abstract class AbstractCompanyCreateEventCoordinator extends AbstractUserCreateEventCoordinator<CompanyCreatedEvent> {
    public AbstractCompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher,
                                                 AbstractOutboxInputPort outboxProcess) {
        super(userMessagePublisher, outboxProcess);
    }

    @Override
    public ProcessProperty getProcess() {
        return new ProcessProperty(CompanyRegistrationSteps.ON_STARTED_STEP.getProcessName(), CompanyRegistrationSteps.ON_STARTED_STEP.name(), Arrays.stream(CompanyRegistrationSteps.values()).map(Enum::name).toList());
    }
}
