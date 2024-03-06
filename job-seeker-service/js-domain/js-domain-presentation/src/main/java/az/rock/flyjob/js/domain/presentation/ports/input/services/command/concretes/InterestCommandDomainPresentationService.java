package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import com.intellibucket.lib.payload.outbox.InterestRegistrationSteps;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

@Component
public class InterestCommandDomainPresentationService implements AbstractInterestCommandDomainPresentationService {

    private final AbstractInterestCreateCommandHandler interestCreateCommandHandler;

    public InterestCommandDomainPresentationService(AbstractInterestCreateCommandHandler interestCreateCommandHandler) {
        this.interestCreateCommandHandler = interestCreateCommandHandler;
    }

    @Override
    public void create(InterestCommandModel interestCommandModel) {
        var interestCreatedEvent = this.interestCreateCommandHandler.add(interestCommandModel);
        var step = InterestRegistrationSteps.ON_STARTED_STEP;
        var saga = AbstractSagaProcess.onProceed(
                step.getProcessName(),
                step,
                interestCreatedEvent
        );
    }

}
