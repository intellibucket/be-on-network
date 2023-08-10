package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CustomPaneCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomPaneCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<CustomPaneCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<CustomPaneCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID customPaneId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
