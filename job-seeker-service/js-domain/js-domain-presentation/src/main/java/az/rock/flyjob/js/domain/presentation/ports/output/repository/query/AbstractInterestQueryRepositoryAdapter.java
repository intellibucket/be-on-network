package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryRepositoryAdapter {

    AnyInterestResponseModel findAnyInterestByResumeId(UUID id);

    List<AnyInterestResponseModel> findAllAnyInterests(SimplePageableRequest pageableRequest);

    List<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(SimplePageableRequest pageableRequest);


}
