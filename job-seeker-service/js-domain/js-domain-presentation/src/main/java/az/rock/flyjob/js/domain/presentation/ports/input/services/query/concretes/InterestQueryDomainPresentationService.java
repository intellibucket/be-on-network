package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InterestQueryDomainPresentationService implements AbstractInterestQueryDomainPresentationService {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;

    public InterestQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder, AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
    }

    @Override
    public MyInterestResponseModel queryMyById(UUID interestUUID) {
        return null;
    }

    @Override
    public List<MyInterestResponseModel> queryMyAll() {
        return null;
    }

    @Override
    public List<MyInterestResponseModel> queryMySimpleAll() {
        return null;
    }
}
