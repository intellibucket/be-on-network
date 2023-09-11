package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.vacancy.AppliedStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "applied_users")
@Entity(name = "AppliedUserEntity")
public class AppliedUserEntity extends BaseEntity {

    @ManyToOne
    private VacancyEntity vacancy;

    @Column(name = "job_seeker_id",nullable = false,updatable = false)
    private UUID jobSeekerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "applied_status", nullable = false)
    private AppliedStatus appliedStatus;
}
