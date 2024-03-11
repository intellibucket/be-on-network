package az.rock.flyjob.js.presentation.api.rest.privates.query;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.flyjob.js.spec.privates.query.resume.detail.ContactQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class ContactCommandPrivateQueryController implements ContactQueryPrivateSpec {

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyContactResponseModel>>> queryAllMyContacts(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyContactResponseModel>>> queryAllAnyContacts(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyContactResponseModel>>> queryAllMySimpleContacts(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyContactResponseModel>>> queryAllAnySimpleContacts(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyContactResponseModel>> findMyContactById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyContactResponseModel>> findAnyContactById(UUID id) {
        return null;
    }
}
