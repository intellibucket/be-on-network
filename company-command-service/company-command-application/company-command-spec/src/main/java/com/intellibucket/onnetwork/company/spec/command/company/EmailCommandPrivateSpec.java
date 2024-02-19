package com.intellibucket.onnetwork.company.spec.command.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmailCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> createEmailByCompany(CompanyEmailCreatedCommand command) ;
    ResponseEntity<JSuccessResponse> changeEmailByCompany(CompanyEmailChangedCommand command) ;
    ResponseEntity<JSuccessResponse> deleteEmailCompany(UUID emailUUID) ;
    ResponseEntity<JSuccessResponse> setPrimaryEmail(UUID emailUUID) ;

}
