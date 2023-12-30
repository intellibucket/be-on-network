package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyPlannerCommand {
    private Timestamp planningDate;
    private Boolean notifyMeWhenIsDone;
}
