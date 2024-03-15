package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InterestQueryDomainPresentationService implements AbstractInterestQueryDomainPresentationService {
    private final AbstractInterestQueryHandler interestQueryHandler;

    public InterestQueryDomainPresentationService(AbstractInterestQueryHandler interestQueryHandler) {
        this.interestQueryHandler = interestQueryHandler;
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
    public List<AnyInterestResponseModel> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageable) {

        var allAnyInterests = this.interestQueryHandler.findAllAnyInterests(targetResumeId, pageable);
        if (!allAnyInterests.isEmpty()) {
            return allAnyInterests;
        } else throw new RuntimeException();


    }

    @Override
    public List<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        var allAnySimpleInterest = this.interestQueryHandler.findAllAnySimpleInterest(targetResumeId, pageable);
        if (!allAnySimpleInterest.isEmpty()) {
            return allAnySimpleInterest;
        } else throw new RuntimeException();
    }

    @Override
    public AnyInterestResponseModel findAnyInterestById(UUID Id) {
        var anyInterest = this.interestQueryHandler.findAntById(Id);
        return anyInterest;
    }
}
