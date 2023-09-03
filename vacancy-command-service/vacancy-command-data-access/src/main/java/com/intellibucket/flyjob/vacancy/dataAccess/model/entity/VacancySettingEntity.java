package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

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
@Table(schema = "vacancy", name = "vacancy_settings")
@Entity(name = "VacancySettingEntity")
public class VacancySettingEntity extends BaseEntity {

    @OneToOne
    private VacancyEntity vacancy;

    @Column(name = "enable_push_notification")
    private Boolean enablePushNotification;

    @Column(name = "enable_email_notification")
    private Boolean enableEmailNotification;

    @Column(name = "only_one_apply_for_candidate")
    private Boolean onlyOneApplyForCandidate;

    @Column(name = "change_vacancy_push_notify")
    private Boolean changeVacancyPushNotify;
}
