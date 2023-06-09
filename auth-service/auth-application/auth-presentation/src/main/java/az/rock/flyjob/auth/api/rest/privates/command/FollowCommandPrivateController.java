package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractFollowQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.FollowCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/follow",produces = MediaType.APPLICATION_JSON_VALUE)
public class FollowCommandPrivateController implements FollowCommandPrivateSpec {

    private AbstractFollowQueryDomainPresentationService followQueryDomainPresentationService;

    @Override
    public ResponseEntity<JSuccessResponse> follow(UUID userID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> unfollow(UUID userID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> acceptFollowRequest(UUID followRelationID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> rejectFollowRequest(UUID followRelationID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> cancelFollowRequest(UUID followRelationID) {
        return null;
    }
}
