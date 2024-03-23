package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import lombok.SneakyThrows;
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
    public MyInterestResponseModel findMyInterestById(UUID id) {
        var myInterest = this.interestQueryHandler.findMyInterestById(id);
        return myInterest;
    }

    @Override
    public List<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        var allMyInterests = this.interestQueryHandler.queryAllMyInterests(pageableRequest);
        if (!allMyInterests.isEmpty()) {
            return allMyInterests;
        } else throw new RuntimeException();
    }

    @Override
    public List<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        var allMySimpleInterests = this.interestQueryHandler.queryAllMySimpleInterests(pageableRequest);
        if (!allMySimpleInterests.isEmpty()) {
            return allMySimpleInterests;
        } else throw new RuntimeException();
    }
    @SneakyThrows
    @Override
    public SimplePageableResponse<AnyInterestResponseModel> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        return this.interestQueryHandler.findAllAnyInterests(targetResumeId, pageable);
    }

    @SneakyThrows
    @Override
    public SimplePageableResponse<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        return this.interestQueryHandler.findAllAnySimpleInterest(targetResumeId, pageable);
    }

    @SneakyThrows
    @Override
    public AnyInterestResponseModel findAnyInterestById(UUID Id) {
        return this.interestQueryHandler.findAnyById(Id);
    }
}
