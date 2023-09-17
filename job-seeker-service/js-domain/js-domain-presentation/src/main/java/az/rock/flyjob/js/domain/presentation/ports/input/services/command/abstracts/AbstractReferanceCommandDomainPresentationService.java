package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReferenceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.annotation.InputPort;

import java.util.UUID;

@InputPort
public interface AbstractReferanceCommandDomainPresentationService {
    void create(ReferenceCommandModel model);

    void update(UpdateRequest<ReferenceCommandModel> request);

    void delete(UUID referenceId);

    void reorder(ReorderCommandModel request);
}
