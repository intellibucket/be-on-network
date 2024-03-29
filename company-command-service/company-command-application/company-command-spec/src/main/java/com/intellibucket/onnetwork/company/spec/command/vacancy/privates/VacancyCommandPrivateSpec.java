package com.intellibucket.onnetwork.company.spec.command.vacancy.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.vacancy.PublishStatus;
import az.rock.lib.valueObject.vacancy.SectoralType;
import az.rock.lib.valueObject.vacancy.SeniorityStatus;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyContextCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyStatusCommand;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface VacancyCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> createVacancy(CreateRequest<VacancyCommand> request);

    ResponseEntity<JSuccessResponse> updatePublishStatus(UpdateRequest<PublishStatus> request);

    ResponseEntity<JSuccessResponse> updateVacancyStatus(UpdateRequest<VacancyStatusCommand> request);

    ResponseEntity<JSuccessResponse> updateSeniorityStatus(UpdateRequest<SeniorityStatus> request);

    ResponseEntity<JSuccessResponse> updateSectoralType(UpdateRequest<SectoralType> request);

    ResponseEntity<JSuccessResponse> cancelPlanner(UUID id);

    ResponseEntity<JSuccessResponse> updateContext(UpdateRequest<VacancyContextCommand> request);

    ResponseEntity<JSuccessResponse> deleteVacancy(UUID id);
    
}
