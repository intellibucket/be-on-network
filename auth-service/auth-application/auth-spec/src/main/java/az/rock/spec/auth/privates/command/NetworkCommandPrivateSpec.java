package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface NetworkCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> sendRequest(UUID userID);
    ResponseEntity<JSuccessResponse> acceptRequest(UUID networkID);

    /**
     * Gelen network isteyini redd etmek isteyen userin networkID-sini gonderir
     */
    ResponseEntity<JSuccessResponse> rejectRequest(UUID networkID);

    /**
     * Oz network isteyini silmek isteyen userin networkID-sini gonderir
     */
    ResponseEntity<JSuccessResponse> cancelRequest(UUID networkID);
    ResponseEntity<JSuccessResponse> deleteNetwork(UUID networkID);
}
