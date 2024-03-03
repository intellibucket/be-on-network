package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyWebsiteUpdatedCommand {
   private String website;
}
