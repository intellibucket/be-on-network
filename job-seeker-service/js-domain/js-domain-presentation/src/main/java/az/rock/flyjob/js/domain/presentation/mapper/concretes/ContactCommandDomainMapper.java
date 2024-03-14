package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactCommandDomainMapper implements AbstractContactCommandDomainMapper {

    @Override
    public ContactRoot toRoot(ContactCommandModel commandModel, ResumeID resumeID) {
        var contactId = ContactID.of(UUID.randomUUID());
        return ContactRoot.Builder.builder()
                .id(contactId)
                .data(commandModel.getData())
                .liveType(commandModel.getLiveType())
                .formatType(commandModel.getFormatType())
                .accessModifier(AccessModifier.PUBLIC)
                .resume(resumeID)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .build();
    }
}