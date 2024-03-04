package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
@Component
public class ContactCommandPresentationHandler implements AbstractContactCommandHandler {
    private final AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter;

    public ContactCommandPresentationHandler(AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter) {
        this.abstractContactCommandRepositoryAdapter = abstractContactCommandRepositoryAdapter;
    }

    @Override
    public ContactCreatedEvent createContact(ContactCommandModel commandModel) {
        return null;
    }

    @Override
    public ContactUpdateEvent updateContact(ContactCommandModel commandModel) {
        return null;
    }

    @Override
    public ContactDeleteEvent deleteContact(UID uid) {
        return null;
    }

}
