package com.intellibucket.onnetwork.vacancy.presentation.command.api.rest.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.vacancy.PublishStatus;
import az.rock.lib.valueObject.vacancy.SectoralType;
import az.rock.lib.valueObject.vacancy.SeniorityStatus;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancyCommand;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancyContextCommand;
import com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request.VacancyStatusCommand;
import com.intellibucket.onnetwork.vacancy.spec.command.privates.VacancyCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/vacancy", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyCommandPrivateController implements VacancyCommandPrivateSpec {

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> createVacancy(@RequestBody CreateRequest<VacancyCommand> request) {
        return null;
    }

    @Override
    @PutMapping("/update-publish-status")
    public ResponseEntity<JSuccessResponse> updatePublishStatus(UpdateRequest<PublishStatus> request) {
        return null;
    }

    @Override
    @PutMapping("/update-vacancy-status")
    public ResponseEntity<JSuccessResponse> updateVacancyStatus(@RequestBody UpdateRequest<VacancyStatusCommand> request) {
        return null;
    }

    @Override
    @PutMapping("/update-seniority-status")
    public ResponseEntity<JSuccessResponse> updateSeniorityStatus(@RequestBody UpdateRequest<SeniorityStatus> request) {
        return null;
    }

    @Override
    @PutMapping("/update-seniority-status")
    public ResponseEntity<JSuccessResponse> updateSectoralType(@RequestBody UpdateRequest<SectoralType> request) {
        return null;
    }

    @Override
    @PutMapping("/cancel-planner/{id}")
    public ResponseEntity<JSuccessResponse> cancelPlanner(@PathVariable(name = "id") UUID id) {
        return null;
    }

    @Override
    @PutMapping("/update-context")
    public ResponseEntity<JSuccessResponse> updateContext(@RequestBody UpdateRequest<VacancyContextCommand> request) {
        return null;
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> deleteVacancy(@PathVariable(name = "id") UUID vacancyId) {
        return null;
    }
}
