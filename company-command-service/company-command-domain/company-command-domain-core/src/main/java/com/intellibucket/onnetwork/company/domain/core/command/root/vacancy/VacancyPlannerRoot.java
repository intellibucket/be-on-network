package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPlannerID;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@Builder
public class VacancyPlannerRoot extends AggregateRoot<VacancyPlannerID> {
    private VacancyID vacancy;

    private ZonedDateTime planningDate;

    private Boolean isDone;

    private Boolean notifyMeWhenIsDone;
}
