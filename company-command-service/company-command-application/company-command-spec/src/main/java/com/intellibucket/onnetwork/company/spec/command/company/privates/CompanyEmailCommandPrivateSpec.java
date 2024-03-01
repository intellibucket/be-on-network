package com.intellibucket.onnetwork.company.spec.command.company.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CompanyEmailCommandPrivateSpec {

    ResponseEntity<JSuccessResponse> createEmailByCompany(CompanyEmailCreatedCommand command) ;
    ResponseEntity<JSuccessResponse> changeEmailByCompany(CompanyEmailChangedCommand command) ;
    void deleteEmailCompany(UUID emailUUID) ;
    ResponseEntity<JSuccessResponse> setPrimaryEmail(UUID emailUUID) ;

}
