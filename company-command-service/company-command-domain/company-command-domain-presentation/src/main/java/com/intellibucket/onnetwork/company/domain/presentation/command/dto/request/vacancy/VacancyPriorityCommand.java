package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.vacancy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyPriorityCommand {
    private UUID vacancyID;
    private Integer priority;
}
