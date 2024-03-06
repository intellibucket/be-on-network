package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email;

import lombok.*;

import java.util.UUID;

//@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CompanyEmailCreatedCommand {
    private String email;
}
