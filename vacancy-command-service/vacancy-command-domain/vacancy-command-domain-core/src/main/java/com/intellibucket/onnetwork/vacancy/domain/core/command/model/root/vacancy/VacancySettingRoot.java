package com.intellibucket.onnetwork.vacancy.domain.core.command.model.root.vacancy;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.vacancy.VacancyID;
import az.rock.lib.domain.id.vacancy.VacancySettingID;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class VacancySettingRoot extends AggregateRoot<VacancySettingID> {
    private VacancyID vacancy;

    private Boolean enablePushNotification;

    private Boolean enableEmailNotification;

    private Boolean onlyOneApplyChancePerCandidate;

    private Boolean pushNotifyWhenVacancyChanged;
}
