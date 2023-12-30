package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyPriorityID;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Builder
public class VacancyPriorityRoot extends AggregateRoot<VacancyPriorityID> {
    private VacancyID vacancy;

    private Integer priority;
}
