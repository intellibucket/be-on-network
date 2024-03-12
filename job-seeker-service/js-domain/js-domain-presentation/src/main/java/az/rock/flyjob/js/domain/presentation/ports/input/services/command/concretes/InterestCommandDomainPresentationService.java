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
    public void create(InterestCommandModel interestCommandModel) {
        try {
            var interestCreatedEvent = this.interestCreateCommandHandler.add(interestCommandModel);

            var step = InterestRegistrationSteps.ON_STARTED_STEP;
            var saga = AbstractSagaProcess.onProceed(
                    step.getProcessName(),
                    step,
                    interestCreatedEvent
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(UpdateRequest<InterestCommandModel> updateRequest){
        try {
            var interestUpdateEvent = this.interestCreateCommandHandler.update(updateRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(UUID interestId){
        try {
            var delete = this.interestCreateCommandHandler.delete(interestId);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void reorder(ReorderCommandModel request) {
        try {
            var reorder = this.interestCreateCommandHandler.reorder(request);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

}
