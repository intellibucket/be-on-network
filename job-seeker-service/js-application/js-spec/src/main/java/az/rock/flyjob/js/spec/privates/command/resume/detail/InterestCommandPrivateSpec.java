package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.core.exception.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface InterestCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<InterestCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<InterestCommandModel> request) throws Exception;

    ResponseEntity<JSuccessResponse> delete(UUID interestId) throws InterestNotFound;

    default ResponseEntity<JSuccessResponse> deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) throws InterestNotFound;
}
