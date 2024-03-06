package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractFollowRelationQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.FollowQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/follow",produces = MediaType.APPLICATION_JSON_VALUE)
public class FollowQueryPrivateController implements FollowQueryPrivateSpec {
    private final AbstractFollowRelationQueryDomainPresentationService followQueryDomainPresentationService;

    public FollowQueryPrivateController(AbstractFollowRelationQueryDomainPresentationService followQueryDomainPresentationService) {
        this.followQueryDomainPresentationService = followQueryDomainPresentationService;
    }

    @Override
    @GetMapping("/my-followers")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyFollowers() {
        List<UUID> entitiesId = this.followQueryDomainPresentationService.findMyFollowers();
        return ResponseEntity.ok(new JSuccessDataResponse<>(entitiesId));
    }

    @Override
    @GetMapping("/my-followings")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyFollowings() {
        List<UUID> entitiesId = this.followQueryDomainPresentationService.findMyFollowings();
        return ResponseEntity.ok(new JSuccessDataResponse<>(entitiesId));
    }

}
