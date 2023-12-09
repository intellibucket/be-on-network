package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.valueObject.WorkingTimeLine;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.vacancy.*;

import java.sql.Timestamp;
import java.util.List;

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

    private List<VacancySkillRoot> skills;

    private Timestamp startDate;

    private Timestamp endDate;

    private WorkingTimeLine workingTimeLine;

    private WorkingType workingType;

    private VacancySalaryRoot salary;

    private VacancyLocationRoot location;

    private List<VacancySaveUserRoot> savedUsers;

    private List<AppliedUserRoot> appliedUsers;

    private List<VacancyTagRoot> tags;

    private List<ViewerRoot> viewers;

    private VacancySettingRoot setting;

}
