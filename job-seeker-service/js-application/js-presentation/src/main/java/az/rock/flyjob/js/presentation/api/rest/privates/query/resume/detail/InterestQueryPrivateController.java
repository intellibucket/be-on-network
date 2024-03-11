package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.spec.privates.query.resume.detail.InterestQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class InterestQueryPrivateController implements InterestQueryPrivateSpec {
    @Override
    @GetMapping()
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyInterestResponseModel>>> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyInterestResponseModel>>> queryAllAnyInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyInterestResponseModel>>> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyInterestResponseModel>>> queryAllAnySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyInterestResponseModel>> findMyInterestById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyInterestResponseModel>> findAnyInterestById(UUID id) {
        return null;
    }
}
