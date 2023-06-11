package az.rock.spec.auth.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface FollowQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyFollowers();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyFollowings();

    ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyFollowPendingRequests();

}
