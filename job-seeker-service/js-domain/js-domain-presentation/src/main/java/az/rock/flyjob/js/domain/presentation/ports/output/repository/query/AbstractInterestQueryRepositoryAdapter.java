package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryRepositoryAdapter {

    Optional<AnyInterestResponseModel> findAntById(UUID resumeId, UUID id,List<AccessModifier> modifier);

    Page<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, Pageable pageableRequest, List<AccessModifier> modifier);

    Page<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, Pageable pageableRequest,List<AccessModifier> modifier);


}
