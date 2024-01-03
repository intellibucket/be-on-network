package com.intellibucket.onnetwork.company.spec.command.company;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.http.ResponseEntity;

public interface TestCompanyPrivateSpec {
    ResponseEntity<JSuccessResponse> createCompany(CompanyRegistrationPayload payload) throws JDomainException;

}
