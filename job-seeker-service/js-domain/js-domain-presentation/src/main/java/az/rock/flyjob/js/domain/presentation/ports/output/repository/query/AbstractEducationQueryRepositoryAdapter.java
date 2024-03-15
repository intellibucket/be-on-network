package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractEducationQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<EducationRoot, EducationID, ResumeID> {
    Optional<EducationRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID educationId);

    List<EducationRoot> findAllMyEducations(ResumeID resumeID, SimplePageableRequest simplePageableRequest);

    List<EducationRoot> findAllMySimpleEducations(ResumeID resumeID, SimplePageableRequest simplePageableRequest);

    List<EducationRoot> findAllAnyEducations(UUID resumeID, SimplePageableRequest simplePageableRequest);


}