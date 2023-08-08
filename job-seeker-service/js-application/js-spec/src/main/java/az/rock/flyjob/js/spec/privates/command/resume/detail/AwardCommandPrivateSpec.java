package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.AwardCreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.AwardUpdateRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AwardCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(AwardCreateRequest request);
    ResponseEntity<JSuccessResponse> update(AwardUpdateRequest request);
    ResponseEntity<JSuccessResponse> delete(UUID awardId);
}
