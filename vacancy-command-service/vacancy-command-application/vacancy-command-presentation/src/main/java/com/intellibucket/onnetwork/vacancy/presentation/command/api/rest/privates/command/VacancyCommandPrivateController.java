package com.intellibucket.onnetwork.vacancy.presentation.command.api.rest.privates.command;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacancy/1.0/private/query/vacancy-command", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyCommandPrivateController implements VacancyCommandPrivateSpec {

    //todo davami yazilacaq ve kontruktoru qurulacaq
    //private final AbstractVacancyCommandPrivateController abstractVacancyCommandPrivateController;


    @Override
    public ResponseEntity<JSuccessDataResponse> createVacancy(CreateRequest<VacancyCommand> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse> updatePublishStatus(UpdateRequest<PublishStatus> request) {
        return null;
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
