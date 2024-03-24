package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<InterestRoot, InterestID, ResumeID> {

    Optional<AnyInterestResponseModel> fetchAnyById(InterestCriteria criteria) ;

    List<AnyInterestResponseModel> fetchAllAnyInterests(InterestCriteria criteria, SimplePageableRequest pageableRequest);

    List<SimpleAnyInterestResponseModel> fetchAllAnySimpleInterest(InterestCriteria criteria,SimplePageableRequest request);

    Optional<InterestRoot> findMyInterestById(InterestCriteria criteria);

    List<InterestRoot> queryAllMyInterests(InterestCriteria criteria,SimplePageableRequest pageableRequest);

    List<InterestRoot> queryAllMySimpleInterests(InterestCriteria criteria,SimplePageableRequest pageableRequest);
//--------------------------------Hibernate queries-----------------------------------
    Optional<InterestRoot> findOwnByID(ResumeID parentID, InterestID rootId, List<AccessModifier> accessModifiers);

    List<InterestRoot> findAllByPID(ResumeID parentID, List<AccessModifier> accessModifiers);

    Optional<Integer> getLimit(ResumeID resumeID);


}
