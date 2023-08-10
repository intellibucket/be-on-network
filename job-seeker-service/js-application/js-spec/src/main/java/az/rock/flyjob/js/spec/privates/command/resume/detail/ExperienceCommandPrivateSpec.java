package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ExperienceCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ExperienceCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<ExperienceCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID experienceId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
