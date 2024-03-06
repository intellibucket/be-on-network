package com.intellibucket.onnetwork.company.dataAccess.command.adapter.query.company;

import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyEmailDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query.CompanyEmailQueryJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyEmailQueryRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyEmailQueryRepositoryAdapter implements AbstractCompanyEmailQueryRepositoryAdapter {
    private final CompanyEmailQueryJPARepository companyEmailQueryJPARepository;

    private final AbstractCompanyEmailDataAccessMapper companyEmailDataAccessMapper;

    public CompanyEmailQueryRepositoryAdapter(CompanyEmailQueryJPARepository companyEmailQueryJPARepository,
                                              AbstractCompanyEmailDataAccessMapper companyEmailDataAccessMapper) {
        this.companyEmailQueryJPARepository = companyEmailQueryJPARepository;
        this.companyEmailDataAccessMapper = companyEmailDataAccessMapper;
    }


    @Override
    public List<EmailRoot> fetchCompanyEmailsByCompanyUuid(CompanyID companyID) {
        var companyEmailEntityOptional = Optional.ofNullable(
                this.companyEmailQueryJPARepository.findEmailEntityByCompanyUuid(companyID.getAbsoluteID())
        );

        return  companyEmailEntityOptional.stream()
                   .map(this.companyEmailDataAccessMapper::toRoot)
                   .filter(Optional::isPresent)
                   .map(Optional::get)
                   .toList();

    }

    @Override
    public Boolean isExistEmailAsActive(String email) {
        return this.companyEmailQueryJPARepository.existsByEmail(email);
    }

    @Override
    public List<EmailRoot> findAllEmails(CompanyID companyID) {
        var entities = this.companyEmailQueryJPARepository.findAllByCompanyId(companyID.getAbsoluteID());
        return entities.stream().map(this.companyEmailDataAccessMapper::toRoot).filter(Optional::isPresent).map(Optional::get).toList();
    }

    @Override
    public Optional<EmailRoot> findEmailById(EmailID emailID) {
        var optionalEntity = Optional.ofNullable(this.companyEmailQueryJPARepository.findEmailById(emailID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.companyEmailDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }

    @Override
    public Optional<EmailRoot> findFirstEmailByCreatedDate(CompanyID companyID) {
        var optionalEntity = Optional.ofNullable(this.companyEmailQueryJPARepository.findFirstEmailByCreatedDate(companyID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.companyEmailDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }

}
