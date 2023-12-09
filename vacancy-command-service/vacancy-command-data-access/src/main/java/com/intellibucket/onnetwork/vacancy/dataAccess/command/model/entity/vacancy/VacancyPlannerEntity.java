package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancy_planners")
@Entity(name = "VacancyPlannerEntity")
public class VacancyPlannerEntity extends BaseEntity {

    @OneToOne
    private VacancyEntity vacancy;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp planningDate;

    @Column(name = "is_done",nullable = false, columnDefinition = "boolean default false")
    private Boolean isDone;

    @Column(name = "notify_me_when_is_done",nullable = false, columnDefinition = "boolean default true")
    private Boolean notifyMeWhenIsDone;
}
