package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyEmailCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.EmailCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/1.0/private/command/company/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailCompanyCommandPrivateController implements EmailCommandPrivateSpec {

    private AbstractCompanyEmailCommandDomainPresentationService abstractCompanyEmailCommandDomainPresentationService;

    public EmailCompanyCommandPrivateController(AbstractCompanyEmailCommandDomainPresentationService abstractCompanyEmailCommandDomainPresentationService) {
        this.abstractCompanyEmailCommandDomainPresentationService = abstractCompanyEmailCommandDomainPresentationService;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<JSuccessResponse> createEmailByCompany(@RequestBody CompanyEmailCreateCommand command) {
        this.abstractCompanyEmailCommandDomainPresentationService.createEmailCompany(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }


}
