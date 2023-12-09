package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPriorityID;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class VacancyPriorityRoot extends AggregateRoot<VacancyPriorityID> {
    private VacancyID vacancy;

    private Integer priority;
}
