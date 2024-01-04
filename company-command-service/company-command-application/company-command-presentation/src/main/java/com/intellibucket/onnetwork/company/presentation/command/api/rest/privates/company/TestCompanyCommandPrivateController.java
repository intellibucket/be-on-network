package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.TestCompanyPrivateSpec;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Profile(value = {"local", "develop", "pre-develop"})
@RequestMapping(value = "/company/1.0/private/command/test/create/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestCompanyCommandPrivateController implements TestCompanyPrivateSpec {

    private AbstractCompanyCommandDomainPresentationService abstractCompanyCommandDomainPresentation;

    public TestCompanyCommandPrivateController(AbstractCompanyCommandDomainPresentationService abstractCompanyTestCommandDomainPresentation) {
        this.abstractCompanyCommandDomainPresentation = abstractCompanyTestCommandDomainPresentation;
    }

    @Override
    @PostMapping("/test")
    public ResponseEntity<JSuccessResponse> createCompany(CompanyRegistrationPayload payload) throws JDomainException {
        this.abstractCompanyCommandDomainPresentation.createCompany(payload);
        return  ResponseEntity.ok(new JSuccessResponse());
    }
}
