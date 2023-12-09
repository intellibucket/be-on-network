package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySkillID;
import az.rock.lib.valueObject.vacancy.VacancySkillType;
import jakarta.persistence.*;

import java.util.UUID;

public class VacancySkillRoot extends AggregateRoot<VacancySkillID> {
    private VacancyID vacancy;

    private VacancySkillType skillType;

    private String skill;
}
