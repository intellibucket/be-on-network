package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactDeletePayload;
import com.intellibucket.lib.payload.payload.ContactMergePayload;
import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.Optional;

@Component
public class ContactCommandPresentationHandler implements AbstractContactCommandHandler {
    private final AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter;
    private final AbstractContactCommandDomainMapper contactCommandDomainMapper;
    private final AbstractSecurityContextHolder contextHolder;

    public ContactCommandPresentationHandler(AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter, AbstractContactCommandDomainMapper contactCommandDomainMapper, AbstractSecurityContextHolder contextHolder) {
        this.abstractContactCommandRepositoryAdapter = abstractContactCommandRepositoryAdapter;
        this.contactCommandDomainMapper = contactCommandDomainMapper;
        this.contextHolder = contextHolder;
    }

    @Override
    public ContactCreatedEvent createContact(ContactCommandModel commandModel) //Create ve Update qalib onlar yazilmalidi yazacam
    {
     return null;
    }

    @Override
    public ContactUpdateEvent updateContact(ContactCommandModel commandModel) {
       return null;
    }

    @Override
    public ContactDeleteEvent deleteContact(UID id) {
        var optionalContactRoot = this.abstractContactCommandRepositoryAdapter.delete(id);
        return ContactDeleteEvent.of(
                ContactDeletePayload.of(
                        optionalContactRoot.orElseThrow(()->new RuntimeException()).getRootID().getRootID()
                )
        );
    }

}
