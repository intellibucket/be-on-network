package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractInterestQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<InterestRoot, InterestID, ResumeID> {
    Boolean existByResumeIDAndName(ResumeID resumeID,InterestRoot interestRoot);
     Optional<InterestRoot> findOwnByID(ResumeID parentID, InterestID rootId,List<AccessModifier> accessModifiers) ;
     Optional<InterestRoot> findByPID(ResumeID parentID, List<AccessModifier> accessModifiers) ;
     List<InterestRoot> findAllByPID(ResumeID parentID,List<AccessModifier> accessModifiers);

    Optional<Integer> getLimit(ResumeID resumeID);






}
