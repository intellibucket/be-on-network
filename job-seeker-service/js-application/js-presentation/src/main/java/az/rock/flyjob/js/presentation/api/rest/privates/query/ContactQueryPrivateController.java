package az.rock.flyjob.js.presentation.api.rest.privates.query;

import az.rock.flyjob.js.domain.core.service.abstracts.AbstractContactDomainService;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommmandDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractContactQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.ContactQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/contact",produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactQueryPrivateController implements ContactQueryPrivateSpec {
    private final AbstractContactQueryDomainPresentationService abstractContactQueryDomainPresentationService;

    public ContactQueryPrivateController(AbstractContactQueryDomainPresentationService abstractContactQueryDomainPresentationService) {
        this.abstractContactQueryDomainPresentationService = abstractContactQueryDomainPresentationService;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyContactResponseModel>>> queryAllMyContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllMyContacts(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyContactResponseModel>>> queryAllAnyContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllAnyContacts(pageableRequest);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyContactResponseModel>>> queryAllMySimpleContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllMySimpleContacts(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyContactResponseModel>>> queryAllAnySimpleContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllAnySimpleContacts(pageableRequest);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyContactResponseModel>> findMyContactById(UUID id) {

        var response =this.abstractContactQueryDomainPresentationService.findMyContactById(id);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyContactResponseModel>> findAnyContactById(UUID id) {
        var response=this.abstractContactQueryDomainPresentationService.findAnyContactById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}
