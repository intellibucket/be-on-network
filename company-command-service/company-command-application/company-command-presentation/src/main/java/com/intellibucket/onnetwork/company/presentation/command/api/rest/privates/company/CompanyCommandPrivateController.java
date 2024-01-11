package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.onnetwork.company.domain.core.command.exception.NoActiveRowException;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.CompanyCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/1.0/private/command/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyCommandPrivateController implements CompanyCommandPrivateSpec {

    private AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService;

    public CompanyCommandPrivateController(AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService) {
        this.companyCommandDomainPresentationService = companyCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/filled")
    public ResponseEntity<JSuccessResponse> fillCompanyInfo(@RequestBody CompanyFilledCommand command) throws NoActiveRowException {
        this.companyCommandDomainPresentationService.filled(command);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
