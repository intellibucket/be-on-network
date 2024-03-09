package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.rmi.server.UID;
import java.util.UUID;

public interface ContactCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ContactCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<ContactCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID contactId);

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
