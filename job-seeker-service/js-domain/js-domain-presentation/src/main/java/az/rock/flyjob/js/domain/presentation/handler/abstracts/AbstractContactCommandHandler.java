package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.UID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractContactCommandHandler {

    ContactCreatedEvent createContact (ContactCommandModel commandModel);

    ContactUpdateEvent updateContact (ContactCommandModel commandModel);

    ContactDeleteEvent deleteContact(UID uid);

}
