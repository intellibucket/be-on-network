package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.lib.domain.id.js.ResumeID;

public interface AbstractEducationDomainMapper {
    EducationRoot toNewRoot(ResumeID resumeID, EducationCommandModel educationCommandModel);

}
