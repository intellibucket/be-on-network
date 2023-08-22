package az.rock.flyjob.js.presentation.api.rest.privates.command;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.OrganizationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.spec.privates.command.resume.detail.OrganizationCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/organization", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationCommandPrivateController implements OrganizationCommandPrivateSpec {
    private final OrganizationCommandPrivateSpec organizationCommandPrivateSpec;

    public OrganizationCommandPrivateController(OrganizationCommandPrivateSpec organizationCommandPrivateSpec) {
        this.organizationCommandPrivateSpec = organizationCommandPrivateSpec;
    }

    @Override
    @PostMapping(value = "/create-organization")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<OrganizationCommandModel> request) {
       return ResponseEntity.ok(new JSuccessResponse());
    }


    @Override
    @PutMapping(value = "/update-organization")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<OrganizationCommandModel> request) {
        return organizationCommandPrivateSpec.update(request);
    }


    @Override
    @DeleteMapping(value = "/delete-organization")
    public ResponseEntity<JSuccessResponse> delete(@RequestBody UUID organizationId) {
        return organizationCommandPrivateSpec.delete(organizationId);
    }


    @Override
    @PutMapping(value = "/reorder-organization")
    public ResponseEntity<JSuccessResponse> reorder(@RequestBody ReorderCommandModel request) {
        return organizationCommandPrivateSpec.reorder(request);
    }
}
