package com.intellibucket.onnetwork.company.domain.core.command.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySkillID;
import az.rock.lib.valueObject.vacancy.VacancySkillType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Builder
public class VacancySkillRoot extends AggregateRoot<VacancySkillID> {
    private VacancyID vacancy;

    private VacancySkillType skillType;

    private String skill;
}
