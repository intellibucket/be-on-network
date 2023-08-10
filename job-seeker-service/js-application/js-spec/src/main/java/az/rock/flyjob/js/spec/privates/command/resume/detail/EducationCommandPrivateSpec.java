package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EducationCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<EducationCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<EducationCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID educationId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
