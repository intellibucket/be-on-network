package az.rock.spec.auth.privates.query;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface FollowQueryPrivateSpec {
    ResponseEntity<List<UUID>> queryMyFollowers();

    ResponseEntity<List<UUID>> queryMyFollowings();

    ResponseEntity<List<UUID>> queryMyFollowPendingRequests();

}
