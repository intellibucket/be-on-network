package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BlockRelationCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> block(UUID targetUserUuid);
    ResponseEntity<JSuccessResponse> unblock(UUID targetUserUuid);
}