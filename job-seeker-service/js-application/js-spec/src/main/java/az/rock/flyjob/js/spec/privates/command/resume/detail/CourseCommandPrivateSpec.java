package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface CourseCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<CourseCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<CourseCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID courseId);

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);

    ResponseEntity<JSuccessResponse> uploadCertificate(UUID courseId, MultipartFile file);
}
