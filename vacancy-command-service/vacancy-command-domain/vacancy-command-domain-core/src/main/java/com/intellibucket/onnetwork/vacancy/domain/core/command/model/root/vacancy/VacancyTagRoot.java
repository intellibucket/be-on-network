package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancyTagID;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class VacancyTagRoot extends AggregateRoot<VacancyTagID> {
    private VacancyID vacancy;

    private String tag;

}
