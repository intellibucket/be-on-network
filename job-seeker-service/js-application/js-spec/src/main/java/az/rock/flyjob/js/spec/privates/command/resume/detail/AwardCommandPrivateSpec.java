package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.AwardCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AwardCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<AwardCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<AwardCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID awardId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
