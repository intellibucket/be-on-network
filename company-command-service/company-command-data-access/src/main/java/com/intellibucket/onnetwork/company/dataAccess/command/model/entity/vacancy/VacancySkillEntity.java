package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.vacancy.VacancySkillType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancy_skills")
@Entity(name = "VacancySkillEntity")
public class VacancySkillEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private VacancyEntity vacancy;

    @Enumerated(EnumType.STRING)
    private VacancySkillType skillType;

    @Column(name = "skill",nullable = false,updatable = false)
    private String skill;

}
