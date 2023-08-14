package az.rock.flyjob.js.spec.privates.command.resume.main;

import az.rock.flyjob.js.domain.presentation.dto.request.AddressCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AddressCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<AddressCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<AddressCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID addressId);
}
