package com.intellibucket.onnetwork.company.dataAccess.command.adapter.query.company;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query.CompanyQueryJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyQueryRepositoryAdapter implements AbstractCompanyQueryRepositoryAdapter {

    private final CompanyQueryJPARepository companyQueryJPARepository;

    private final AbstractCompanyDataAccessMapper companyDataAccessMapper;

    public CompanyQueryRepositoryAdapter(CompanyQueryJPARepository companyQueryJPARepository,
                                         AbstractCompanyDataAccessMapper companyDataAccessMapper) {
        this.companyQueryJPARepository = companyQueryJPARepository;
        this.companyDataAccessMapper = companyDataAccessMapper;
    }


    @Override
    public Optional<CompanyRoot> getCompanyRoot(CompanyID companyID) {
        var companyEntityOptional = Optional.ofNullable(
                this.companyQueryJPARepository
                        .findCompanyEntity(companyID.getAbsoluteID())
        );
        if (companyEntityOptional.isPresent())
            return this.companyDataAccessMapper.toRoot(companyEntityOptional.get());
        return Optional.empty();
    }
}
