package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractBlockRelationQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.BlockRelationQueryPrivateSpec;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/auth/1.0/private/query/block",produces = MediaType.APPLICATION_JSON_VALUE)
public class BlockRelationQueryPrivateController implements BlockRelationQueryPrivateSpec {

    private final AbstractBlockRelationQueryDomainPresentationService blockRelationQueryDomainPresentationService;

    public BlockRelationQueryPrivateController(AbstractBlockRelationQueryDomainPresentationService blockRelationQueryDomainPresentationService) {
        this.blockRelationQueryDomainPresentationService = blockRelationQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-my-blocked-users/")
    public ResponseEntity<JSuccessDataResponse<List<UUID>>> queryMyBlockedUsers() {
        var response = this.blockRelationQueryDomainPresentationService.queryMyBlockedUser();
        return new ResponseEntity<>(new JSuccessDataResponse<>(response), HttpStatus.OK);
    }
}
