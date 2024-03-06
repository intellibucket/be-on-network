package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ResumeLanguageCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ResumeLanguageCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ResumeLanguageCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<ResumeLanguageCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID resumeLanguageId);

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
