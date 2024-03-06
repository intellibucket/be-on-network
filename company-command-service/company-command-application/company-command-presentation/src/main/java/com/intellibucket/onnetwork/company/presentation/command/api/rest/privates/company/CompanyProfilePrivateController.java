package com.intellibucket.onnetwork.company.presentation.command.api.rest.privates.company;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Switch;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyProfileCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.spec.command.company.privates.CompanyProfileCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@CrossOrigin
@RestController
@RequestMapping(value = "/company/1.0/private/command/company/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyProfilePrivateController implements CompanyProfileCommandPrivateSpec {
    private AbstractCompanyProfileCommandDomainPresentationService companyProfileCommandDomainPresentationService;

    public CompanyProfilePrivateController(AbstractCompanyProfileCommandDomainPresentationService
                                                   companyProfileCommandDomainPresentationService) {
        this.companyProfileCommandDomainPresentationService = companyProfileCommandDomainPresentationService;
    }


    @PatchMapping("/change/hiring-status")
    public ResponseEntity<JSuccessResponse> changeHiringStatus(@RequestParam("switcher") Switch switcher){
        this.companyProfileCommandDomainPresentationService.changeHiringStatus(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }


    @DeleteMapping("/delete")
    public ResponseEntity<JSuccessResponse> deleteCompanyProfile(){
        this.companyProfileCommandDomainPresentationService.deleteCompanyProfile();
        return ResponseEntity.ok(new JSuccessResponse());
    }


}
