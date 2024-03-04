package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.create.EducationCreatedEvent;
import com.intellibucket.lib.payload.event.delete.EducationDeletedEvent;
import com.intellibucket.lib.payload.event.update.EducationUpdatedEvent;


import java.util.UUID;

public interface AbstractEducationCommandHandler {

    EducationCreatedEvent create(CreateRequest<EducationCommandModel> request);

    EducationUpdatedEvent update(UpdateRequest<EducationCommandModel> request);

    EducationDeletedEvent delete(UUID educationId);

    EducationUpdatedEvent reorder(ReorderCommandModel request);
}
