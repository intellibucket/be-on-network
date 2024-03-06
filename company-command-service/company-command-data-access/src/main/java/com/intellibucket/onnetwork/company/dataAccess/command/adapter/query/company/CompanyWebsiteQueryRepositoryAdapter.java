package com.intellibucket.onnetwork.company.dataAccess.command.adapter.query.company;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractWebsiteDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query.CompanyWebsiteQueryJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyWebsiteQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyWebsiteQueryRepositoryAdapter implements AbstractCompanyWebsiteQueryRepositoryAdapter {

    private final CompanyWebsiteQueryJPARepository companyWebsiteQueryJPARepository;

    private final AbstractWebsiteDataAccessMapper companyWebsiteDataAccessMapper;

    public CompanyWebsiteQueryRepositoryAdapter(CompanyWebsiteQueryJPARepository companyWebsiteQueryJPARepository,
                                                AbstractWebsiteDataAccessMapper companyWebsiteDataAccessMapper) {
        this.companyWebsiteQueryJPARepository = companyWebsiteQueryJPARepository;
        this.companyWebsiteDataAccessMapper = companyWebsiteDataAccessMapper;
    }

    @Override
    public Optional<WebsiteRoot> findCompanyWebsiteByCompanyId(CompanyID companyID) {
        var optionalEntity = Optional.ofNullable(this.companyWebsiteQueryJPARepository
                                     .findWebsiteEntityByCompanyUuid(companyID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.companyWebsiteDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }
}
