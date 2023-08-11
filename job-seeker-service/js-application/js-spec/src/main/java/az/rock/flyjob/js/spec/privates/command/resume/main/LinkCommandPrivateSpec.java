package az.rock.flyjob.js.spec.privates.command.resume.main;

import az.rock.flyjob.js.domain.presentation.dto.request.LinkCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface LinkCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<LinkCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<LinkCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID linkId);
    ResponseEntity<JSuccessResponse> deleteAll();
    ResponseEntity<JSuccessResponse> hide(UUID linkId);
    ResponseEntity<JSuccessResponse> hideAll();
}
