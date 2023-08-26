package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.OrganizationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractOrganizationCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.OrganizationCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.common.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/organization", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationCommandPrivateController implements OrganizationCommandPrivateSpec {
    private final AbstractOrganizationCommandDomainPresentationService abstractOrganizationCommandDomainPresentationService;

    public OrganizationCommandPrivateController(AbstractOrganizationCommandDomainPresentationService abstractOrganizationCommandDomainPresentationService) {
        this.abstractOrganizationCommandDomainPresentationService = abstractOrganizationCommandDomainPresentationService;
    }


    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(CreateRequest<OrganizationCommandModel> request) {
        this.abstractOrganizationCommandDomainPresentationService.createOrganization();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<OrganizationCommandModel> request) {
        this.abstractOrganizationCommandDomainPresentationService.updateOrganization();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<JSuccessResponse> delete(UUID organizationId) {
        this.abstractOrganizationCommandDomainPresentationService.deleteOrganization();
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        this.abstractOrganizationCommandDomainPresentationService.reorderOrganization();
        return ResponseEntity.ok(new JSuccessResponse());
    }

}
