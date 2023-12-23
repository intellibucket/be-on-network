package com.intellibucket.onnetwork.vacancy.presentation.command.api.rest.privates.query;

import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
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
@RequestMapping(value = "/vacancy/1.0/private/query/vacancy-command", produces = MediaType.APPLICATION_JSON_VALUE)

public class AbstractVacancyQueryDomainPresentationService implements VacancyCommandPrivateSpec {

    private final AbstractVacancyQueryDomainPresentationService abstractVacancyQueryDomainPresentationService;

    public AbstractVacancyQueryDomainPresentationService(AbstractVacancyQueryDomainPresentationService abstractVacancyQueryDomainPresentationService) {
        this.abstractVacancyQueryDomainPresentationService = abstractVacancyQueryDomainPresentationService;
    }


    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessDataResponse> createVacancy(CreateRequest<VacancyCommand> request) {
        var response = this.abstractVacancyQueryDomainPresentationService.createVacancy(request);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessDataResponse> updatePublishStatus(UpdateRequest<PublishStatus> request) {
        var response = this.abstractVacancyQueryDomainPresentationService.updatePublishStatus(request);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    public ResponseEntity<JSuccessResponse> updateVacancyStatus(UpdateRequest<VacancyStatusCommand> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> updateSeniorityStatus(UpdateRequest<SeniorityStatus> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> updateSectoralType(UpdateRequest<SectoralType> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> cancelPlanner(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> updateContext(UpdateRequest<VacancyContextCommand> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> deleteVacancy(UUID id) {
        return null;
    }
}
