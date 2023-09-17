package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReferenceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractReferanceCommandDomainPresentationService;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class ReferanceCommandDomainPresentationService implements AbstractReferanceCommandDomainPresentationService {
    @Override
    public void create(ReferenceCommandModel model) {

    }

    @Override
    public void update(UpdateRequest<ReferenceCommandModel> request) {

    }

    @Override
    public void delete(UUID referenceId) {

    }

    @Override
    public void reorder(ReorderCommandModel request) {

    }
}
