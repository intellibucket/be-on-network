package com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.request;

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
