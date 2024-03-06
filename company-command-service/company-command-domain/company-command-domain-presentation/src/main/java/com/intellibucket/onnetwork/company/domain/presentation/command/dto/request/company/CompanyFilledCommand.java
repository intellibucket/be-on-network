package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyFilledCommand {
    private String name;
    private String description;
}
