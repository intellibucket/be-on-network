package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.event.create.website.CompanyWebsiteCreatedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteDeletedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteUpdatedEvent;
import com.intellibucket.lib.payload.website.CompanyWebsiteCreatedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteDeletedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteUpdatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.exception.FoundMoreThanOneActiveRow;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyWebsiteDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteUpdatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.exception.DomainException;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyWebsiteCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyWebsiteDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyWebsiteCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyWebsiteQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public CompanyWebsiteCreatedEvent createWebsiteByCompany(CompanyWebsiteCreatedCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var websiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        if(!websiteRoot.isPresent()) {
            var newEmailRoot = this.companyWebsiteDomainMapper.toNewCompanyWebsiteRoot(command,currentCompany);
            var savedRoot = this.companyWebsiteCommandRepositoryAdapter.create(newEmailRoot);
            if (savedRoot.isEmpty()) throw new DomainException("F0000000001");
            return CompanyWebsiteCreatedEvent.of(new CompanyWebsiteCreatedPayload());
        }else{
            throw new FoundMoreThanOneActiveRow("F0000000009");
        }
    }

    @Override
    public CompanyWebsiteUpdatedEvent changeWebsiteByCompany(CompanyWebsiteUpdatedCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresentOrElse(oldWebsiteRoot -> {
            this.companyWebsiteDomainService.validateIsSameWebsite(oldWebsiteRoot, command.getWebsite());
            var newWebsiteRoot = this.companyWebsiteDomainMapper.mapToWebsiteRoot(oldWebsiteRoot, command);
            this.companyWebsiteCommandRepositoryAdapter.update(newWebsiteRoot);
        }, () -> {throw new NoActiveRowException();
        });
        return CompanyWebsiteUpdatedEvent.of(new CompanyWebsiteUpdatedPayload());
    }

    @Override
    public CompanyWebsiteDeletedEvent deleteWebsiteCompany() {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresentOrElse(
                websiteRoot -> this.companyWebsiteCommandRepositoryAdapter.inActive(websiteRoot),
                () -> {
                    throw new NoActiveRowException();
                }
        );
        return CompanyWebsiteDeletedEvent.of(new CompanyWebsiteDeletedPayload());

    }
}
