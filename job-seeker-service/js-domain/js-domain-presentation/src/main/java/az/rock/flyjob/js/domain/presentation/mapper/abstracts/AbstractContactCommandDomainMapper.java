package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.lib.domain.id.js.ResumeID;

public interface AbstractContactCommandDomainMapper {
    ContactRoot ToRoot (ResumeID resumeID, ContactCommandModel commandModel);
}
