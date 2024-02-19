package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEmailCreatedCommand {
    private String email;
}
