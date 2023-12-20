package com.intellibucket.onnetwork.vacancy.presentation.command.api.rest.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancySalaryCommand;
import com.intellibucket.onnetwork.vacancy.spec.command.privates.VacancySalaryCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/salary", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancySalaryCommandPrivateController implements VacancySalaryCommandPrivateSpec {

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<JSuccessResponse> updateVacancySalary(@RequestBody UpdateRequest<VacancySalaryCommand> request) {
        return null;
    }
}
