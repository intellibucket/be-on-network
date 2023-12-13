package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.vacancy;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.WorkingTimeLine;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.vacancy.*;
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
@Table(name = "vacancies", schema = "vacancy", indexes = {
        @Index(name = "ıdx_vacancyentity_process_and_row_status", columnList = "process_status, row_status"),
        @Index(name = "ıdx_vacancyentity_title", columnList = "title"),
        @Index(name = "ıdx_vacancyentity", columnList = "vacancy_status")
})
@Entity(name = "VacancyEntity")
public class VacancyEntity extends BaseEntity {

    @Column(name = "company_id",nullable = false,updatable = false)
    private UUID companyID;

    @Enumerated(EnumType.STRING)
    @Column(length = 32, columnDefinition = "varchar(32) default 'PUBLIC'")
    private AccessModifier accessModifier;

    @OneToOne(mappedBy = "vacancy")
    private VacancyPriorityEntity priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacancy_status",nullable = false, columnDefinition = "varchar(40) default 'DRAFT'")
    private VacancyStatus vacancyStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "publish_status",nullable = false, columnDefinition = "varchar(40) default 'STANDARD'")
    private PublishStatus publishStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "package_status",nullable = false, columnDefinition = "varchar(40) default 'STANDARD'")
    private VacancyPackageStatus packageStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "seniority_status",nullable = false, columnDefinition = "varchar(40) default 'UNDEFINED'")
    private SeniorityStatus seniorityStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "sectoral_type",nullable = false, columnDefinition = "varchar(40) default 'UNDEFINED'")
    private SectoralType sectoralType;

    @OneToOne(mappedBy = "vacancy")
    private VacancyPlannerEntity planner;

    @Column(name = "title",nullable = false,length = 500)
    private String title;

    @Column(name = "description",nullable = false,length = 5000)
    private String description;

    @Column(name = "requeriments",nullable = false,length = 5000)
    private String requeriments;

    @Column(name = "responsibilities",nullable = false,length = 5000)
    private String responsibilities;

    @OneToMany(mappedBy = "vacancy")
    private List<VacancySkillEntity> skills;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endDate;

    @Enumerated(EnumType.STRING)
    private WorkingTimeLine workingTimeLine;

    @Enumerated(EnumType.STRING)
    private WorkingType workingType;

    @OneToOne(mappedBy = "vacancy")
    private VacancySalaryEntity salary;

    @OneToOne(mappedBy = "vacancy")
    private VacancyLocationEntity location;

    @OneToMany(mappedBy = "vacancy")
    private List<VacancySaveUserEntity> savedUsers;

    @OneToMany(mappedBy = "vacancy")
    private List<AppliedUserEntity> appliedUsers;

    @OneToMany(mappedBy = "vacancy")
    private List<VacancyTagEntity> tags;

    @OneToMany(mappedBy = "vacancy")
    private List<ViewerEntity> viewers;

    @OneToOne(mappedBy = "vacancy")
    private VacancySettingEntity setting;
}
