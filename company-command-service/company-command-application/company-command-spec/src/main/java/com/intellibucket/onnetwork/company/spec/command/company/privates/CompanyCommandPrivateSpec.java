package com.intellibucket.onnetwork.company.spec.command.company.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.http.ResponseEntity;

public interface CompanyCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> fillCompanyInfo(CompanyFilledCommand command) ;
}
