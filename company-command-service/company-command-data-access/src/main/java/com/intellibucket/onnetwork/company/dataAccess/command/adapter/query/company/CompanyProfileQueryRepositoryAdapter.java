package com.intellibucket.onnetwork.company.dataAccess.command.adapter.query.company;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyProfileDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query.CompanyProfileQueryJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyProfileQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyProfileQueryRepositoryAdapter implements AbstractCompanyProfileQueryRepositoryAdapter {
    private final CompanyProfileQueryJPARepository companyProfileQueryJPARepository;

    private final AbstractCompanyProfileDataAccessMapper companyProfileDataAccessMapper;

    public CompanyProfileQueryRepositoryAdapter(CompanyProfileQueryJPARepository companyProfileQueryJPARepository,
                                                AbstractCompanyProfileDataAccessMapper companyProfileDataAccessMapper) {
        this.companyProfileQueryJPARepository = companyProfileQueryJPARepository;
        this.companyProfileDataAccessMapper = companyProfileDataAccessMapper;
    }

    @Override
    public Optional<CompanyProfileRoot> findCompanyProfileByCompanyId(CompanyID companyID) {
        var optionalEntity = Optional.ofNullable(this.companyProfileQueryJPARepository.findCompanyProfileEntityByCompanyUuid(companyID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.companyProfileDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }
}
