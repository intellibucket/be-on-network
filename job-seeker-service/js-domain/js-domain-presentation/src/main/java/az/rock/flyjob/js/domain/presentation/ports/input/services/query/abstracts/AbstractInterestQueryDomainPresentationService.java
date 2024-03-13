package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@InputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryDomainPresentationService {
    MyInterestResponseModel queryMyById(UUID interestUUID);
    List<MyInterestResponseModel> queryMyAll();
    List<MyInterestResponseModel> queryMySimpleAll();
//-------------------------------------------------------
    List<AnyInterestResponseModel> queryAllAnyInterests(SimplePageableRequest pageableRequest);
   List< SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(SimplePageableRequest pageableRequest);

    AnyInterestResponseModel findAnyInterestById(UUID id);

}
