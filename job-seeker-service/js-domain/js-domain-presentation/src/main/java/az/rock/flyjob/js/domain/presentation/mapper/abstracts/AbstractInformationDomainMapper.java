package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.lib.domain.id.js.ResumeID;

public interface AbstractInformationDomainMapper {
    InformationRoot createNewInformation(ResumeID resumeID,String firstName,String lastName);
}
