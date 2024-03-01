package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.onnetwork.company.domain.core.command.exception.FoundMoreThanOneActiveRow;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyWebsiteDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.exception.DomainException;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyWebsiteCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyWebsiteDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyWebsiteCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyWebsiteQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyWebsiteCommandHandler implements AbstractCompanyWebsiteCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractCompanyWebsiteQueryRepositoryAdapter companyWebsiteQueryRepositoryAdapter;
    private final AbstractCompanyWebsiteCommandRepositoryAdapter companyWebsiteCommandRepositoryAdapter;
    private final AbstractCompanyWebsiteDomainMapper companyWebsiteDomainMapper;

    private final AbstractCompanyWebsiteDomainService companyWebsiteDomainService;


    public CompanyWebsiteCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractCompanyWebsiteQueryRepositoryAdapter
                                                companyWebsiteQueryRepositoryAdapter,
                                        AbstractCompanyWebsiteCommandRepositoryAdapter
                                                companyWebsiteCommandRepositoryAdapter,
                                        AbstractCompanyWebsiteDomainMapper companyWebsiteDomainMapper,
                                        AbstractCompanyWebsiteDomainService companyWebsiteDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.companyWebsiteQueryRepositoryAdapter = companyWebsiteQueryRepositoryAdapter;
        this.companyWebsiteCommandRepositoryAdapter = companyWebsiteCommandRepositoryAdapter;
        this.companyWebsiteDomainMapper = companyWebsiteDomainMapper;
        this.companyWebsiteDomainService = companyWebsiteDomainService;
    }

    @Override
    public void createWebsiteByCompany(CompanyWebsiteCreatedCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var websiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        if(!websiteRoot.isPresent()) {
            var newEmailRoot = this.companyWebsiteDomainMapper.toNewCompanyEmailRoot(command,currentCompany);
            var savedRoot = this.companyWebsiteCommandRepositoryAdapter.create(newEmailRoot);
            if (savedRoot.isEmpty()) throw new DomainException("F0000000001");
        }else{
            throw new FoundMoreThanOneActiveRow("F0000000009");
        }
    }

    @Override
    public void changeWebsiteByCompany(CompanyWebsiteCreatedCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresent(oldWebsiteRoot -> {
            this.companyWebsiteDomainService.validateIsSameWebsite(oldWebsiteRoot, command.getWebsite());
            var newWebsiteRoot = this.companyWebsiteDomainMapper.mapToWebsiteRoot(oldWebsiteRoot, command);
            this.companyWebsiteCommandRepositoryAdapter.update(newWebsiteRoot);
        });
    }

    @Override
    public void deleteWebsiteCompany() {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresentOrElse(
                websiteRoot -> this.companyWebsiteCommandRepositoryAdapter.inActive(websiteRoot),
                () -> {
                    throw new NoActiveRowException();
                }
        );
    }
}
