package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySaveID;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class VacancySaveUserRoot extends AggregateRoot<VacancySaveID> {
    private VacancyID vacancy;

    private UserID userId;
}
