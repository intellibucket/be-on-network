package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.spec.privates.command.resume.detail.InterestCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/interest", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterestCommandPrivateController implements InterestCommandPrivateSpec {
    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(CreateRequest<InterestCommandModel> request) {
        return null;
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<InterestCommandModel> request) {
        return null;
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(UUID interestId) {
        return null;
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        return null;
    }
}
