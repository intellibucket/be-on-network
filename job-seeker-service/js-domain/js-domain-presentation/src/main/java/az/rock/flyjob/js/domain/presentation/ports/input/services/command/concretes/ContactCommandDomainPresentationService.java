package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommmandDomainPresentationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
public class ContactCommandDomainPresentationService implements AbstractContactCommmandDomainPresentationService {


    private final AbstractContactCommandHandler abstractContactCommandHandler;

    public ContactCommandDomainPresentationService(AbstractContactCommandHandler abstractContactCommandHandler) {
        this.abstractContactCommandHandler = abstractContactCommandHandler;
    }

    @Override
    public void create(CreateRequest<ContactCommandModel> request) {

    }

    @Override
    public void update(UpdateRequest<ContactCommandModel> request) {

    }

    @Override
    public void delete(UUID contactId) {

    }

    @Override
    public void reorder(ReorderCommandModel request) {

    }
}
