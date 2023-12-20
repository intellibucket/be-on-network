package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.vacancy.LocationID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Builder
@SuperBuilder
public class VacancyLocationRoot extends AggregateRoot<LocationID> {
    private VacancyID vacancy;

    private UUID cityId;
}
