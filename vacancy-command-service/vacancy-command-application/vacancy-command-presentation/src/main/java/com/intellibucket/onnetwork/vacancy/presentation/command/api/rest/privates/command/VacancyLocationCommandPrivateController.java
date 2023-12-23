package com.intellibucket.onnetwork.vacancy.presentation.command.api.rest.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancyLocationCommand;
import com.intellibucket.onnetwork.vacancy.spec.command.privates.VacancyLocationCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/location", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyLocationCommandPrivateController implements VacancyLocationCommandPrivateSpec {


    @Override
    @PostMapping(value = "/update")
    public ResponseEntity<JSuccessResponse> updateVacancyLocation(@RequestBody UpdateRequest<VacancyLocationCommand> request) {
        return null;
    }

}
