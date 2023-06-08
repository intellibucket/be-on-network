package az.rock.spec.auth.privates.query;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface NetworkQueryPrivateSpec {
    /**
     * This method returns the list of user id who are in my network
     */
    ResponseEntity<List<UUID>> queryMyNetworks();

    /**
     * This method returns the list of user id who are in my network and their request is pending
     */
    ResponseEntity<List<UUID>> queryInMyNetworkPendingRequests();

    /**
     * This method returns the list of user id who are in my network and I have sent request to them
     */
    ResponseEntity<List<UUID>> queryMyPendingRequests();
}
