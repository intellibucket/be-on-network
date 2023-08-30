package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.FollowCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/relationFollow",produces = MediaType.APPLICATION_JSON_VALUE)
public class FollowCommandPrivateController implements FollowCommandPrivateSpec {

    private AbstractFollowCommandDomainPresentationService followCommandDomainPresentationService;

    public FollowCommandPrivateController(AbstractFollowCommandDomainPresentationService abstractFollowCommandDomainPresentationService){
        this.followCommandDomainPresentationService = abstractFollowCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/follow/{uuid}")
    public ResponseEntity<JSuccessResponse> follow(@PathVariable(name = "uuid") UUID userID) {
        this.followCommandDomainPresentationService.follow(userID);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/unfollow/{uuid}")
    public ResponseEntity<JSuccessResponse> unfollow(@PathVariable(name = "uuid") UUID userID) {
        this.followCommandDomainPresentationService.unfollow(userID);
        return ResponseEntity.ok(new JSuccessResponse());
    }


}
