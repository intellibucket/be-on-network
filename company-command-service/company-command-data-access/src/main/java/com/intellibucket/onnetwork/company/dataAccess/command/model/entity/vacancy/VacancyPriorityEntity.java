package com.intellibucket.onnetwork.company.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancy_priorities")
@Entity(name = "VacancyPriorityEntity")
public class VacancyPriorityEntity extends BaseEntity {
    @OneToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private VacancyEntity vacancy;

    @Column(name = "priority",nullable = false, columnDefinition = "int default 0")
    private Integer priority;
}
