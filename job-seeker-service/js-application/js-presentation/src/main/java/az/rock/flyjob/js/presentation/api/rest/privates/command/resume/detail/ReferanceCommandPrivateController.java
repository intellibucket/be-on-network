package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReferenceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractReferanceCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ReferenceCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/referance")
public class ReferanceCommandPrivateController implements ReferenceCommandPrivateSpec {

    private final AbstractReferanceCommandDomainPresentationService referanceCommandDomainPresentationService;

    public ReferanceCommandPrivateController(AbstractReferanceCommandDomainPresentationService referanceCommandDomainPresentationService) {
        this.referanceCommandDomainPresentationService = referanceCommandDomainPresentationService;
    }

    @Override
    @PostMapping(value = "/create")
    public ResponseEntity<JSuccessResponse> create(CreateRequest<ReferenceCommandModel> request) {
        var model = request.getModel();
        this.referanceCommandDomainPresentationService.create(model);
        return new ResponseEntity<>(new JSuccessResponse(), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<ReferenceCommandModel> request) {
        this.referanceCommandDomainPresentationService.update(request);
        return new ResponseEntity<>(new JSuccessResponse(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<JSuccessResponse> delete(UUID referenceId) {
        this.referanceCommandDomainPresentationService.delete(referenceId);
        return new ResponseEntity<>(new JSuccessResponse(), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        this.referanceCommandDomainPresentationService.reorder(request);
        return new ResponseEntity<>(new JSuccessResponse(), HttpStatus.OK);
    }
}
