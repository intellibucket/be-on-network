package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractNetworkCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.NetworkCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/networkRelation",produces = MediaType.APPLICATION_JSON_VALUE)
public class NetworkCommandPrivateController implements NetworkCommandPrivateSpec {

    private AbstractNetworkCommandDomainPresentationService abstractNetworkCommandDomainPresentationService;

    public NetworkCommandPrivateController(AbstractNetworkCommandDomainPresentationService abstractNetworkCommandDomainPresentationService) {
        this.abstractNetworkCommandDomainPresentationService = abstractNetworkCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/sendRequest/{uuid}")
    public ResponseEntity<JSuccessResponse> sendRequest(@PathVariable(name = "uuid") UUID userID) {
        this.abstractNetworkCommandDomainPresentationService.sendRequest(userID);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/acceptRequest")
    public ResponseEntity<JSuccessResponse> acceptRequest() {
        this.abstractNetworkCommandDomainPresentationService.acceptRequest();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/rejectRequest/{uuid}")
    public ResponseEntity<JSuccessResponse> rejectRequest(@PathVariable(name = "uuid") UUID targetUserId) {
        this.abstractNetworkCommandDomainPresentationService.rejectRequest(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/cancelRequest/{uuid}")
    public ResponseEntity<JSuccessResponse> cancelRequest(@PathVariable(name = "uuid")UUID targetUserId) {
        this.abstractNetworkCommandDomainPresentationService.cancelRequest(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/deleteNetwork/{uuid}")
    public ResponseEntity<JSuccessResponse> deleteNetwork(@PathVariable(name = "uuid")  UUID targetUserId) {
        this.abstractNetworkCommandDomainPresentationService.deleteNetwork(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
