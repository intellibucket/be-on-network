package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReferenceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ReferenceCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ReferenceCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<ReferenceCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID referenceId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
