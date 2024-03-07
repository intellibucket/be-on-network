package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.InterestNameIsExist;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import com.intellibucket.lib.payload.event.create.InterestCreateEvent;
import com.intellibucket.lib.payload.event.update.InterestDeleteEvent;
import com.intellibucket.lib.payload.event.update.InterestUpdateEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractInterestCreateCommandHandler {
    InterestCreateEvent add(InterestCommandModel interestCommandModel);

    InterestUpdateEvent update(UpdateRequest<InterestCommandModel> interestCommandModelUpdateRequest) throws InterestNameIsExist, Exception;

    InterestDeleteEvent delete(UUID interestId);

    //reoerder metodu yazilmalidi



}
