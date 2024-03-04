package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommmandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ContactCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/contact", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactCommandPrivateController implements ContactCommandPrivateSpec {

    private final AbstractContactCommmandDomainPresentationService abstractContactCommmandDomainPresentationService;

    public ContactCommandPrivateController(AbstractContactCommmandDomainPresentationService abstractContactCommmandDomainPresentationService) {
        this.abstractContactCommmandDomainPresentationService = abstractContactCommmandDomainPresentationService;
    }


    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<ContactCommandModel> request) {
        return contactCommandPrivateService.create(request);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<ContactCommandModel> request) {
        return contactCommandPrivateService.update(request);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable("id") UUID contactId) {

        return contactCommandPrivateService.delete(contactId);
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {

        return contactCommandPrivateService.reorder(request);
    }
}
