package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.EducationPayload;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractEducationCommandHandler<E extends AbstractDomainEvent<EducationPayload>> {

    E create(CreateRequest<EducationCommandModel> request);

    E update(UpdateRequest<EducationCommandModel> request);

    E delete(UUID educationId);

    E reorder(ReorderCommandModel request);
}
