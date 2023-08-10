package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.OrganizationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface OrganizationCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<OrganizationCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<OrganizationCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID organizationId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
