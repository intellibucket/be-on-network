package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

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

public interface AbstractVacancyCommandDomainPresentationService {
    void createVacancy(CreateRequest<VacancyCommand> request);

    void updatePublishStatus(UpdateRequest<PublishStatus> request);

    void updateVacancyStatus(UpdateRequest<VacancyStatusCommand> request);

    void updateSeniorityStatus(UpdateRequest<SeniorityStatus> request);

    void updateSectoralType(UpdateRequest<SectoralType> request);

    void cancelPlanner(VacancyPlannerID id);

    void updateContext(UpdateRequest<VacancyContextCommand> request);

    void deleteVacancy(VacancyID id);
}
