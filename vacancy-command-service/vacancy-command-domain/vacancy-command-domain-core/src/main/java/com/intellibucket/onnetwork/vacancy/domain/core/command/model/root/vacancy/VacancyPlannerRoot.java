package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPlannerID;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Builder
@SuperBuilder
public class VacancyPlannerRoot extends AggregateRoot<VacancyPlannerID> {
    private VacancyID vacancy;

    private Timestamp planningDate;

    private Boolean isDone;

    private Boolean notifyMeWhenIsDone;
}
