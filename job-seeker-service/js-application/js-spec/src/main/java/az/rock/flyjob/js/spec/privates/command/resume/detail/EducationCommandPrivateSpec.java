package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EducationCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<EducationCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<EducationCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID educationId);

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
