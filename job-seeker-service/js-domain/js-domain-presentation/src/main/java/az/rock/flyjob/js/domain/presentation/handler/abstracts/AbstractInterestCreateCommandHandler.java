package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import com.intellibucket.lib.payload.event.create.InterestCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractInterestCreateCommandHandler {
    InterestCreatedEvent add(InterestCommandModel interestCommandModel);
}
