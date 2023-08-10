package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.SkillCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface SkillCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<SkillCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<SkillCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID skillId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
