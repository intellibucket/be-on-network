package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractEducationQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.EducationQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EducationQueryPrivateController implements EducationQueryPrivateSpec {


    private final AbstractEducationQueryDomainPresentationService educationQueryDomainPresentationService;
    public EducationQueryPrivateController(AbstractEducationQueryDomainPresentationService abstractEducationQueryDomainPresentationService) {
        this.educationQueryDomainPresentationService = educationQueryDomainPresentationService;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyEducationResponseModel>>> queryAllMyEducations(SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllMyEducations(pageableRequest);
        return ResponseEntity.ok(JSuccessDataResponse.of(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyEducationResponseModel>>> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllAnyEducations(targetResumeId,pageableRequest);
        return ResponseEntity.ok(JSuccessDataResponse.of(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyEducationResponseModel>>> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllMySimpleEducations(pageableRequest);
        return ResponseEntity.ok(JSuccessDataResponse.of(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyEducationResponseModel>>> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyEducationResponseModel>> findMyEducationById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyEducationResponseModel>> findAnyEducationById(UUID id) {
        return null;
    }
}