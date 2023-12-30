package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyLocationCommand {
    private UUID cityId;
}
