package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractBlockRelationCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.BlockRelationCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/block",produces = MediaType.APPLICATION_JSON_VALUE)
public class BlockRelationCommandPrivateController implements BlockRelationCommandPrivateSpec {

    private final AbstractBlockRelationCommandDomainPresentationService blockRelationCommandDomainPresentationService;

    public BlockRelationCommandPrivateController(AbstractBlockRelationCommandDomainPresentationService blockRelationCommandDomainPresentationService) {
        this.blockRelationCommandDomainPresentationService = blockRelationCommandDomainPresentationService;
    }

    @Override
    @PostMapping(value = "/block-user/{targetUserUuid}")
    public ResponseEntity<JSuccessResponse> block(@PathVariable(value = "targetUserUuid") UUID targetUserUuid) {
        this.blockRelationCommandDomainPresentationService.block(targetUserUuid);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping(value = "/unblock-user/{targetUserUuid}")
    public ResponseEntity<JSuccessResponse> unblock(@PathVariable(value = "targetUserUuid") UUID targetUserUuid) {
        this.blockRelationCommandDomainPresentationService.unblock(targetUserUuid);
        return ResponseEntity.ok(new JSuccessResponse());
    }

}
