package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
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


    //-------------------------------------------------------------------------
    @Override
    public List<AnyInterestResponseModel> queryAllAnyInterests(SimplePageableRequest pageableRequest) {

        return null;
    }

    @Override
    public List<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public AnyInterestResponseModel findAnyInterestById(UUID id) {

        var resumeID = this.securityContextHolder.availableResumeID();
        final ResumeID resumeID1 = this.securityContextHolder.availableResumeID();
        final AnyInterestResponseModel anyInterestByResumeId = this.interestQueryRepositoryAdapter.findAnyInterestByResumeId(id);
        return null;
    }
}
