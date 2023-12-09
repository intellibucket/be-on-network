package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.vacancy.LocationID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class VacancyLocationRoot extends AggregateRoot<LocationID> {
    private VacancyID vacancy;

    private UUID countryId;

    private UUID cityId;
}
