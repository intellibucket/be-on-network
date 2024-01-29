package com.intellibucket.onnetwork.company.spec.command.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.http.ResponseEntity;

public interface EmailCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> createEmailByCompany(CompanyEmailCreateCommand command) ;

}
