package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates;

import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPlannerID;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.vacancy.PublishStatus;
import az.rock.lib.valueObject.vacancy.SectoralType;
import az.rock.lib.valueObject.vacancy.SeniorityStatus;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyContextCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyStatusCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractVacancyCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.privates.VacancyCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/command/vacancy", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyCommandPrivateController implements VacancyCommandPrivateSpec {

    private final AbstractVacancyCommandDomainPresentationService vacancyCommandDomainPresentationService;

    public VacancyCommandPrivateController(AbstractVacancyCommandDomainPresentationService vacancyCommandDomainPresentationService) {
        this.vacancyCommandDomainPresentationService = vacancyCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> createVacancy(@RequestBody CreateRequest<VacancyCommand> request) {
        this.vacancyCommandDomainPresentationService.createVacancy(request);
        return ResponseEntity.accepted().body(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update-publish-status")
    public ResponseEntity<JSuccessResponse> updatePublishStatus(UpdateRequest<PublishStatus> request) {
        this.vacancyCommandDomainPresentationService.updatePublishStatus(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update-vacancy-status")
    public ResponseEntity<JSuccessResponse> updateVacancyStatus(@RequestBody UpdateRequest<VacancyStatusCommand> request) {
        this.vacancyCommandDomainPresentationService.updateVacancyStatus(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update-seniority-status")
    public ResponseEntity<JSuccessResponse> updateSeniorityStatus(@RequestBody UpdateRequest<SeniorityStatus> request) {
        this.vacancyCommandDomainPresentationService.updateSeniorityStatus(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update-sectorial-type")
    public ResponseEntity<JSuccessResponse> updateSectoralType(@RequestBody UpdateRequest<SectoralType> request) {
        this.vacancyCommandDomainPresentationService.updateSectoralType(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/cancel-planner/{id}")
    public ResponseEntity<JSuccessResponse> cancelPlanner(@PathVariable(name = "id") UUID id) {
        this.vacancyCommandDomainPresentationService.cancelPlanner(new VacancyPlannerID(id));
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update-context")
    public ResponseEntity<JSuccessResponse> updateContext(@RequestBody UpdateRequest<VacancyContextCommand> request) {
        this.vacancyCommandDomainPresentationService.updateContext(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> deleteVacancy(@PathVariable(name = "id") UUID vacancyId) {
        this.vacancyCommandDomainPresentationService.deleteVacancy(new VacancyID(vacancyId));
        return ResponseEntity.ok(JSuccessResponse.success());
    }
}
