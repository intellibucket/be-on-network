package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.*;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ContactCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(ContactCreateRequest request);
    ResponseEntity<JSuccessResponse> update(ContactUpdateRequest request);
    ResponseEntity<JSuccessResponse> delete(UUID contactId);
}
