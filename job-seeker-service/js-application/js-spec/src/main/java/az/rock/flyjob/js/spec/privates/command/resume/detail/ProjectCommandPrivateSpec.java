package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProjectCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ProjectCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<ProjectCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID projectId);

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
