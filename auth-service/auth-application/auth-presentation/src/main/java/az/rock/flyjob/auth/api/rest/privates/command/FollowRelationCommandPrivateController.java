package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowRelationCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.FollowRelationCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/relationFollow",produces = MediaType.APPLICATION_JSON_VALUE)
public class FollowRelationCommandPrivateController implements FollowRelationCommandPrivateSpec {

    private AbstractFollowRelationCommandDomainPresentationService followRelationCommandDomainPresentationService;

    public FollowRelationCommandPrivateController(AbstractFollowRelationCommandDomainPresentationService abstractFollowCommandDomainPresentationService){
        this.followRelationCommandDomainPresentationService = abstractFollowCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/follow/{uuid}")
    public ResponseEntity<JSuccessResponse> follow(@PathVariable(name = "uuid") UUID targetUserId) {
        this.followRelationCommandDomainPresentationService.follow(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/unfollow/{uuid}")
    public ResponseEntity<JSuccessResponse> unfollow(@PathVariable(name = "uuid") UUID targetUserId) {
        this.followRelationCommandDomainPresentationService.unfollow(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping("/remove/{uuid}")
    public ResponseEntity<JSuccessResponse> remove(@PathVariable(name = "uuid") UUID targetUserId) {
        this.followRelationCommandDomainPresentationService.remove(targetUserId);
        return ResponseEntity.ok(new JSuccessResponse());
    }


}
