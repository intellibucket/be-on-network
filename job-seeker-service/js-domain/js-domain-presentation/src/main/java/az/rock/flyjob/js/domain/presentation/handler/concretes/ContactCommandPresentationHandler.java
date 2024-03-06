package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactCommandQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactDeletePayload;
import com.intellibucket.lib.payload.payload.ContactMergePayload;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ContactCommandPresentationHandler implements AbstractContactCommandHandler {
    private final AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter;
    private final AbstractContactCommandQueryRepositoryAdapter commandQueryRepositoryAdapter;
    private final AbstractContactCommandDomainMapper contactCommandDomainMapper;
    private final AbstractSecurityContextHolder contextHolder;

    public ContactCommandPresentationHandler(AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter, AbstractContactCommandQueryRepositoryAdapter commandQueryRepositoryAdapter,
                                             AbstractContactCommandDomainMapper contactCommandDomainMapper,
                                             AbstractSecurityContextHolder contextHolder) {
        this.abstractContactCommandRepositoryAdapter = abstractContactCommandRepositoryAdapter;
        this.commandQueryRepositoryAdapter = commandQueryRepositoryAdapter;
        this.contactCommandDomainMapper = contactCommandDomainMapper;
        this.contextHolder = contextHolder;
    }

    @Override
    public ContactCreatedEvent createContact(CreateRequest<ContactCommandModel> createRequest) //Create ve Update qalib onlar yazilmalidi yazacam
    {

//        var resumeID = contextHolder.availableResumeID();
//        var allResumeID=commandQueryRepositoryAdapter.findAllByPID(resumeID);
//        var newContactRoot=this.contactCommandDomainMapper.toRoot(createRequest.getModel(),resumeID);

        return null;
//     return abstractContactCommandRepositoryAdapter.create(contactCommandDomainMapper.toRoot(commandModel));
    }

    @Override
    public ContactUpdateEvent updateContact(UpdateRequest<ContactCommandModel> commandModel) {
        //todo mapper 'CommandModel' to  'ContactRoot'
        var resumeID = contextHolder.availableResumeID();
        var allByPID = commandQueryRepositoryAdapter.findAllByPID(resumeID);
        Optional<ContactRoot> findedcontact = allByPID.stream().filter(item -> item.getRootID()
                .equals(commandModel.getTargetId())).findFirst();
        if (findedcontact.isPresent()) {
            var contactRoot = findedcontact.get();
            var newRoot = contactRoot.changeFormatType(commandModel.getModel().getFormatType())
                    .changeData(commandModel.getModel().getData())
                    .changeLiveType(commandModel.getModel().getLiveType());
            abstractContactCommandRepositoryAdapter.update(newRoot);

        }
//
        return abstractContactCommandRepositoryAdapter.update();
    }

    @Override
    public ContactDeleteEvent deleteContact(UUID id) {
        var optionalContactRoot = this.abstractContactCommandRepositoryAdapter.delete(id);
//        return ContactDeleteEvent.of(
//                ContactDeletePayload.of(
//                        optionalContactRoot.orElseThrow(()->new RuntimeException()).getRootID().getRootID()
//                )
//        );

        return null;
    }

}
