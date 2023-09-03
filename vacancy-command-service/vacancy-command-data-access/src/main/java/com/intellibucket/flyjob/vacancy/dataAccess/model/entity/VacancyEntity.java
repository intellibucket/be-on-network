package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.WorkingTimeLine;
import az.rock.lib.valueObject.WorkingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancies")
@Entity(name = "VacancyEntity")
public class VacancyEntity extends BaseEntity {

    @Column(name = "company_id",nullable = false,updatable = false)
    private UUID companyID;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "about",nullable = false)
    private String about;

    @Column(name = "requeriments",nullable = false)
    private String requeriments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endDate;

    @Enumerated(EnumType.STRING)
    private WorkingTimeLine workingTimeLine;

    @Enumerated(EnumType.STRING)
    private WorkingType workingType;

    @OneToMany(mappedBy = "vacancy")
    private List<AppliedUserEntity> appliedUsers;

    @OneToMany(mappedBy = "vacancy")
    private List<VacancyTagEntity> vacancyTagEntities;
}
