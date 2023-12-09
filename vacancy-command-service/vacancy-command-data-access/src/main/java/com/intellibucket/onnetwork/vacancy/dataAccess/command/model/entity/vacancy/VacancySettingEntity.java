package com.intellibucket.onnetwork.vacancy.dataAccess.command.model.entity.vacancy;

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

    @Column(name = "enable_push_notification" ,nullable = false, columnDefinition = "boolean default true")
    private Boolean enablePushNotification;

    @Column(name = "enable_email_notification",nullable = false, columnDefinition = "boolean default false")
    private Boolean enableEmailNotification;

    @Column(name = "only_one_apply_chance_per_candidate" ,nullable = false, columnDefinition = "boolean default false")
    private Boolean onlyOneApplyChancePerCandidate;

    @Column(name = "push_notify_when_vacancy_changed",nullable = false, columnDefinition = "boolean default false")
    private Boolean pushNotifyWhenVacancyChanged;
}
