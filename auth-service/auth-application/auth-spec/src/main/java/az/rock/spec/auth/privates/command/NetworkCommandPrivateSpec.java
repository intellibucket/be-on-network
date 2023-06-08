package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface NetworkCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> addRequest(UUID userID);
    ResponseEntity<JSuccessResponse> acceptRequest(UUID networkID);
    ResponseEntity<JSuccessResponse> rejectRequest(UUID networkID);
    ResponseEntity<JSuccessResponse> cancelRequest(UUID networkID);
    ResponseEntity<JSuccessResponse> deleteNetwork(UUID networkID);
}
