package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<InterestRoot, InterestID, ResumeID> {

    Optional<AnyInterestResponseModel> findAntById(UUID resumeId, UUID id,List<AccessModifier> modifier);

    Page<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, Pageable pageableRequest, List<AccessModifier> modifier);

    Page<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, Pageable pageableRequest,List<AccessModifier> modifier);


    Optional<InterestRoot> findOwnByID(ResumeID parentID, InterestID rootId, List<AccessModifier> accessModifiers);

    List<InterestRoot> findAllByPID(ResumeID parentID, List<AccessModifier> accessModifiers);

    Optional<Integer> getLimit(ResumeID resumeID);


}
