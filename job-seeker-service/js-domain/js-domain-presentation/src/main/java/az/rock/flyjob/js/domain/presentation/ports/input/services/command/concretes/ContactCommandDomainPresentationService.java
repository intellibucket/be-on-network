package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommmandDomainPresentationService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactCommandDomainPresentationService implements AbstractContactCommmandDomainPresentationService {


    private final AbstractContactCommandHandler abstractContactCommandHandler;

    public ContactCommandDomainPresentationService(AbstractContactCommandHandler abstractContactCommandHandler) {
        this.abstractContactCommandHandler = abstractContactCommandHandler;
    }

    @SneakyThrows
    @Override
    public void create(CreateRequest<ContactCommandModel> request) {
        abstractContactCommandHandler.createContact(request);
    }

    @SneakyThrows
    @Override
    public void update(UpdateRequest<ContactCommandModel> request) {
        abstractContactCommandHandler.updateContact(request);
    }

    @SneakyThrows
    @Override
    public void delete(UUID contactId) {
        abstractContactCommandHandler.deleteContact(contactId);
    }

    @SneakyThrows
    @Override
    public void reorder(ReorderRequest<ContactCommandModel> request) {
        abstractContactCommandHandler.reOrderContact(request);

    }

}
