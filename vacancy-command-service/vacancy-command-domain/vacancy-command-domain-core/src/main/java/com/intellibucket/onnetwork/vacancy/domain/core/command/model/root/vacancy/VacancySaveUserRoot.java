package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySaveID;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class VacancySaveUserRoot extends AggregateRoot<VacancySaveID> {
    private VacancyID vacancy;

    private UserID userId;
}
