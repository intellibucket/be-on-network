package az.rock.spec.auth.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BlockRelationQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyBlockedUsers();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryWhoBlockedMe();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyBlockedUserById(UUID targetUserId);



}