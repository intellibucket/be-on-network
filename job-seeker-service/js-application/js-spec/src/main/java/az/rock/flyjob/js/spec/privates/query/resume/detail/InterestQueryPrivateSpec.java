package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface InterestQueryPrivateSpec {

    ResponseEntity<SimplePageableResponse<MyInterestResponseModel>> queryAllMyInterests(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<AnyInterestResponseModel>> queryAllAnyInterests(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<SimpleMyInterestResponseModel>> queryAllMySimpleInterests(SimplePageableRequest pageableRequest);

    ResponseEntity<SimplePageableResponse<SimpleAnyInterestResponseModel>> queryAllAnySimpleInterests(SimplePageableRequest pageableRequest);

    ResponseEntity<MyInterestResponseModel> findMyInterestById(UUID id);

    ResponseEntity<AnyInterestResponseModel> findAnyInterestById(UUID id);

}
