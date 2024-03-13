package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.InterestQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/interest", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterestQueryPrivateController implements InterestQueryPrivateSpec {

    private final AbstractInterestQueryDomainPresentationService domainPresentationService;

    public InterestQueryPrivateController(@Qualifier("interestQueryDomainPresentationService") AbstractInterestQueryDomainPresentationService domainPresentationService) {
        this.domainPresentationService = domainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-my/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyInterestResponseModel>>> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    @GetMapping(value = "/get-any/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyInterestResponseModel>>> queryAllAnyInterests(UUID targetResumeId,@RequestBody SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    @GetMapping(value = "/get-my-simple/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyInterestResponseModel>>> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    @GetMapping(value = "/get-simple/any")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyInterestResponseModel>>> queryAllAnySimpleInterests(UUID targetResumeId,@RequestBody SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    @GetMapping(value = "/get-my/{interestUUID}")
    public ResponseEntity<JSuccessDataResponse<MyInterestResponseModel>> findMyInterestById(UUID id) {
        return null;
    }

    @Override
    @GetMapping(value = "/get-any/{interestId}")
    public ResponseEntity<JSuccessDataResponse<AnyInterestResponseModel>> findAnyInterestById(@PathVariable(name = "interestId") UUID id) {
        return null;
    }
}
