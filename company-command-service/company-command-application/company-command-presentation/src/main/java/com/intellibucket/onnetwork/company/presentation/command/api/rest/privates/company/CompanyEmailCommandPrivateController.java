package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyEmailCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.EmailCommandPrivateSpec;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/1.0/private/command/company/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyEmailCommandPrivateController implements EmailCommandPrivateSpec {

    private AbstractCompanyEmailCommandDomainPresentationService abstractCompanyEmailCommandDomainPresentationService;

    public CompanyEmailCommandPrivateController(AbstractCompanyEmailCommandDomainPresentationService abstractCompanyEmailCommandDomainPresentationService) {
        this.abstractCompanyEmailCommandDomainPresentationService = abstractCompanyEmailCommandDomainPresentationService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<JSuccessResponse> createEmailByCompany(@RequestBody CompanyEmailCreatedCommand command) {
        this.abstractCompanyEmailCommandDomainPresentationService.createEmailCompany(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }
    @PatchMapping("/change")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public ResponseEntity<JSuccessResponse> changeEmailByCompany(@RequestBody CompanyEmailChangedCommand command) {
        this.abstractCompanyEmailCommandDomainPresentationService.changeEmailCompany(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }


}
