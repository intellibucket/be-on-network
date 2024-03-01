package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyWebsiteCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.privates.CompanyWebsiteCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/1.0/private/command/company/website", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyWebsiteCommandPrivateController implements CompanyWebsiteCommandPrivateSpec {
    private AbstractCompanyWebsiteCommandDomainPresentationService companyWebsiteCommandDomainPresentationService;

    public CompanyWebsiteCommandPrivateController(AbstractCompanyWebsiteCommandDomainPresentationService
                                                          companyWebsiteCommandDomainPresentationService) {
        this.companyWebsiteCommandDomainPresentationService = companyWebsiteCommandDomainPresentationService;
    }


    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> createWebsiteByCompany(@RequestBody CompanyWebsiteCreatedCommand command) {
        this.companyWebsiteCommandDomainPresentationService.createWebsiteByCompany(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }


    @PatchMapping("/update")
    @Override
    public ResponseEntity<JSuccessResponse> changeWebsiteByCompany(@RequestBody CompanyWebsiteCreatedCommand command) {
        this.companyWebsiteCommandDomainPresentationService.changeWebsiteByCompany(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }


    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<JSuccessResponse> deleteWebsiteCompany() {
        this.companyWebsiteCommandDomainPresentationService.deleteWebsiteCompany();
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
