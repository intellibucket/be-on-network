package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.spec.auth.privates.query.NetworkQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/follow",produces = MediaType.APPLICATION_JSON_VALUE)
public class FollowQueryPrivateController implements NetworkQueryPrivateSpec {
    @Override
    public ResponseEntity<List<UUID>> queryMyNetworks() {
        return null;
    }

    @Override
    public ResponseEntity<List<UUID>> queryInMyNetworkPendingRequests() {
        return null;
    }

    @Override
    public ResponseEntity<List<UUID>> queryMyPendingRequests() {
        return null;
    }
}
