package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.lib.domain.id.js.ResumeID;

public class ContactCommandDomainMapper implements AbstractContactCommandDomainMapper {
    @Override
    public ContactRoot ToRoot(ResumeID resumeID, ContactCommandModel commandModel) {
        return ContactRoot.Builder.builder()
                .id()
                .build();
    }
}
