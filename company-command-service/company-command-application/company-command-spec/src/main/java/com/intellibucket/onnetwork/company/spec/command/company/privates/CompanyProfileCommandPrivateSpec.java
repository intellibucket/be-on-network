package com.intellibucket.onnetwork.company.spec.command.company.privates;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Switch;
import org.springframework.http.ResponseEntity;

public interface CompanyProfileCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> changeHiringStatus(Switch switcher);

    ResponseEntity<JSuccessResponse> deleteCompanyProfile();
}
