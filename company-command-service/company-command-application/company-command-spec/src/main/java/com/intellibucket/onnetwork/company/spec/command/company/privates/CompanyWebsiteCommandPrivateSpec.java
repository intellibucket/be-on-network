package com.intellibucket.onnetwork.company.spec.command.company.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteUpdatedCommand;
import org.springframework.http.ResponseEntity;

public interface CompanyWebsiteCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> createWebsiteByCompany(CompanyWebsiteCreatedCommand command) ;
    ResponseEntity<JSuccessResponse> changeWebsiteByCompany(CompanyWebsiteUpdatedCommand command) ;
    ResponseEntity<JSuccessResponse> deleteWebsiteCompany() ;
}
