package com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request;

import az.rock.lib.valueObject.WorkingTimeLine;
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

    private WorkingTimeLine workingTimeLine;

    private WorkingType workingType;
}
