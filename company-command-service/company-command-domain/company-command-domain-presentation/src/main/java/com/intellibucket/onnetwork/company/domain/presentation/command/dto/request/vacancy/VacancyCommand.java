package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy;

import az.rock.lib.valueObject.WorkingTimeLine;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.vacancy.PublishStatus;
import az.rock.lib.valueObject.vacancy.SectoralType;
import az.rock.lib.valueObject.vacancy.SeniorityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyCommand {
    private VacancyStatusCommand vacancyStatus;

    private PublishStatus publishStatus;

    private SeniorityStatus seniorityStatus;

    private SectoralType sectoralType;

    private VacancyPlannerCommand planner;

    private String title;

    private String description;

    private String requeriments;

    private String responsibilities;

    private List<VacancySkillCommand> skills;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private WorkingTimeLine workingTimeLine;

    private WorkingType workingType;

    private VacancySalaryCommand salary;

    private VacancyLocationCommand location;

    private VacancySettingCommand setting;
}
