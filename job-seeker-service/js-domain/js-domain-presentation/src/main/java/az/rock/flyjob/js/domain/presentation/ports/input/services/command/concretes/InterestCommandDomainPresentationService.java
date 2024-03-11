package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.core.exception.InterestOverLimit;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import com.intellibucket.lib.payload.outbox.InterestRegistrationSteps;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterestCommandDomainPresentationService implements AbstractInterestCommandDomainPresentationService {

    private final AbstractInterestCreateCommandHandler interestCreateCommandHandler;

    public InterestCommandDomainPresentationService(AbstractInterestCreateCommandHandler interestCreateCommandHandler) {
        this.interestCreateCommandHandler = interestCreateCommandHandler;
    }

    @Override
    public void create(InterestCommandModel interestCommandModel) throws InterestNameIsExist, InterestOverLimit {
        var interestCreatedEvent = this.interestCreateCommandHandler.add(interestCommandModel);
        var step = InterestRegistrationSteps.ON_STARTED_STEP;
        var saga = AbstractSagaProcess.onProceed(
                step.getProcessName(),
                step,
                interestCreatedEvent
        );
    }

    @Override
    public void update(UpdateRequest<InterestCommandModel> updateRequest) throws Exception {
       var interestUpdateEvent= this.interestCreateCommandHandler.update(updateRequest);
    }

    @Override
    public void delete(UUID interestId) throws InterestNotFound {
        var delete = this.interestCreateCommandHandler.delete(interestId);
    }

    @Override
    public void reorder(ReorderCommandModel request) throws InterestNotFound {
       var reorder = this.interestCreateCommandHandler.reorder(request);


    }

}
