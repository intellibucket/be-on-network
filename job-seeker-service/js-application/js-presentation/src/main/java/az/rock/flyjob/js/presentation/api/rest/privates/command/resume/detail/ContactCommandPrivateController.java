package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ContactCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class ContactCommandPrivateController implements ContactCommandPrivateSpec {


    @Override
    public ResponseEntity<JSuccessResponse> create(CreateRequest<ContactCommandModel> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<ContactCommandModel> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> delete(UUID contactId) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        return null;
    }
}
