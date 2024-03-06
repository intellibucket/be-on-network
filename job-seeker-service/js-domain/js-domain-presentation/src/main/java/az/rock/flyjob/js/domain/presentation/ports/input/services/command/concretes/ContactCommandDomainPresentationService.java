package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommmandDomainPresentationService;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Component
public class ContactCommandDomainPresentationService implements AbstractContactCommmandDomainPresentationService {


    private final AbstractContactCommandHandler abstractContactCommandHandler;

    public ContactCommandDomainPresentationService(AbstractContactCommandHandler abstractContactCommandHandler) {
        this.abstractContactCommandHandler = abstractContactCommandHandler;
    }

    @Override
    public void create(CreateRequest<ContactCommandModel> request) {
        var courseCreatedEvent = abstractContactCommandHandler.createContact(request);
    }

    @Override
    public void update(UpdateRequest<ContactCommandModel> request) {
        var courseUpdatedEvent = abstractContactCommandHandler.updateContact(request);
    }

    @Override
    public void delete(UUID contactId) {
        var contactDeleteEvent = abstractContactCommandHandler.deleteContact(contactId);
    }

    @Override
    public void reorder(ReorderRequest<ContactCommandModel> request) {
        var contactDeleteEvent = abstractContactCommandHandler.reoderContact(request);

    }

}
