package az.rock.flyjob.js.domain.presentation.handler.query.abstracts;

import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional(propagation =Propagation.REQUIRES_NEW)
public interface AbstractInterestQueryHandler {
    SimplePageableResponse<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest) throws InterestNotFound;
    SimplePageableResponse<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, SimplePageableRequest pageableRequest) throws InterestNotFound;
    AnyInterestResponseModel findAnyById(UUID id) throws InterestNotFound;
    MyInterestResponseModel findMyInterestById(UUID id);
    List<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest);
    List<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest);
}