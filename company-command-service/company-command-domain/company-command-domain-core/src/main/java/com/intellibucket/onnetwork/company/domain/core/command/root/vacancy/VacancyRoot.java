package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.vacancy.*;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
public class VacancyRoot extends AggregateRoot<VacancyID> {

    private UserID companyID;

    private VacancyPriorityRoot priority;

    private VacancyStatus vacancyStatus;

    private PublishStatus publishStatus;

    private VacancyPackageStatus packageStatus;

    private SeniorityStatus seniorityStatus;

    private SectoralType sectoralType;

    private VacancyPlannerRoot planner;

    private String title;

    private String description;

    private String requeriments;

    private String responsibilities;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private WorkingTimeLineType workingTimeLine;

    private WorkingType workingType;

    private List<VacancySkillRoot> skills;

    private VacancySalaryRoot salary;

    private VacancyLocationRoot location;

    private List<VacancySaveUserRoot> savedUsers;

    private List<AppliedUserRoot> appliedUsers;

    private List<VacancyTagRoot> tags;

    private List<ViewerRoot> viewers;

    private VacancySettingRoot setting;


}
