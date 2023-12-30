package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancySettingCommand {
    private Boolean enablePushNotification;

    private Boolean enableEmailNotification;

    private Boolean onlyOneApplyChancePerCandidate;

    private Boolean pushNotifyWhenVacancyChanged;
}
