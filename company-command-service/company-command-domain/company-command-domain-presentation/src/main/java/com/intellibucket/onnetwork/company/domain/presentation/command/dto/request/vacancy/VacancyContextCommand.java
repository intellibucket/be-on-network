package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy;

import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyContextCommand {
    private String title;

    private String description;

    private String requeriments;

    private String responsibilities;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private WorkingTimeLineType workingTimeLine;

    private WorkingType workingType;
}
