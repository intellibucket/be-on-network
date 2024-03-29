package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.vacancy;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancySalaryCommand;
import com.intellibucket.onnetwork.company.spec.command.vacancy.privates.VacancySalaryCommandPrivateSpec;
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
