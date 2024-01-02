package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.vacancy;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyPriorityCommand;
import com.intellibucket.onnetwork.company.spec.command.privates.VacancyPriorityCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/priority", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyPriorityCommandPrivateController implements VacancyPriorityCommandPrivateSpec {

    @Override
    @PutMapping(value = "/update-priority")
    public ResponseEntity<JSuccessResponse> updatePriority(@RequestBody VacancyPriorityCommand request) {
        return null;
    }

    @Override
    @PutMapping(value = "/balance-priority")
    public ResponseEntity<JSuccessResponse> balancePriority(@RequestBody List<VacancyPriorityCommand> request) {
        return null;
    }
}
