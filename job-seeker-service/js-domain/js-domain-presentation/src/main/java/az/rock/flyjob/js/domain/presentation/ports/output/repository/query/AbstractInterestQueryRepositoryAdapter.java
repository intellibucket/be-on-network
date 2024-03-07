package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;

@DomainOutputPort
public interface AbstractInterestQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<InterestRoot, InterestID, ResumeID> {
    Boolean existByResumeIDAndName(ResumeID resumeID,InterestRoot interestRoot);
}
