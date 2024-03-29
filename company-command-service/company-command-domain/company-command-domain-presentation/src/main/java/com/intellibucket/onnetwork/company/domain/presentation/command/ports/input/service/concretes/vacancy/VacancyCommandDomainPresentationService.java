package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.vacancy;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPlannerID;
import az.rock.lib.valueObject.vacancy.PublishStatus;
import az.rock.lib.valueObject.vacancy.SectoralType;
import az.rock.lib.valueObject.vacancy.SeniorityStatus;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.CreateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.abstracts.UpdateRequest;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyContextCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy.VacancyStatusCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.vacancy.AbstractVacancyCommandDomainPresentationService;
import org.springframework.stereotype.Service;

@Service
@InputPort
public class VacancyCommandDomainPresentationService implements AbstractVacancyCommandDomainPresentationService {
    @Override
    public void createVacancy(CreateRequest<VacancyCommand> request) {

    }

    @Override
    public void updatePublishStatus(UpdateRequest<PublishStatus> request) {

    }

    @Override
    public void updateVacancyStatus(UpdateRequest<VacancyStatusCommand> request) {

    }

    @Override
    public void updateSeniorityStatus(UpdateRequest<SeniorityStatus> request) {

    }

    @Override
    public void updateSectoralType(UpdateRequest<SectoralType> request) {

    }

    @Override
    public void cancelPlanner(VacancyPlannerID id) {

    }

    @Override
    public void updateContext(UpdateRequest<VacancyContextCommand> request) {

    }

    @Override
    public void deleteVacancy(VacancyID id) {

    }
}
