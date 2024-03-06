package az.rock.flyjob.auth.api.rest.privates.query;


import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractBlockRelationQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.BlockRelationQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/block",produces = MediaType.APPLICATION_JSON_VALUE)
public class BlockRelationQueryPrivateController implements BlockRelationQueryPrivateSpec {

    private final AbstractBlockRelationQueryDomainPresentationService blockRelationQueryDomainPresentationService;

    public BlockRelationQueryPrivateController(AbstractBlockRelationQueryDomainPresentationService blockRelationQueryDomainPresentationService) {
        this.blockRelationQueryDomainPresentationService = blockRelationQueryDomainPresentationService;
    }

    /**
     * senin blockladiglarivin siyahisini getirir
     * */
    @Override
    @GetMapping("/my-blockedList")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyBlockedUsers() {
        List<UUID> entitiesId = this.blockRelationQueryDomainPresentationService.findMyBlockedList();
        return ResponseEntity.ok(new JSuccessDataResponse<>(entitiesId));
    }

    @Override
    @GetMapping("/who-blocked-me")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryWhoBlockedMe() {
        List<UUID> entitiesId = this.blockRelationQueryDomainPresentationService.queryWhoBlockedMe();
        return ResponseEntity.ok(new JSuccessDataResponse<>(entitiesId));
    }

    /**
     * spesific kimi bloklamisansa ID ye gore onu getirir
     * */
    @Override
    @GetMapping("/my-blockedById/{uuid}")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyBlockedUserById(@PathVariable(name = "uuid") UUID targetUserId) {
        List<UUID> entitiesId = this.blockRelationQueryDomainPresentationService.queryMyBlockedUserById(targetUserId);
        return ResponseEntity.ok(new JSuccessDataResponse<>(entitiesId));
    }




}
