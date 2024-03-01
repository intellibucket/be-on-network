package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyProfileCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyProfileCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyProfileCommandRepositoryAdapter implements AbstractCompanyProfileCommandRepositoryAdapter {
    private final AbstractCustomCompanyProfileCommandJPARepository companyProfileCommandCustomJPARepository;

    private final AbstractDataAccessMapper<CompanyProfileEntity, CompanyProfileRoot> companyProfileDataAccessMapper;

    public CompanyProfileCommandRepositoryAdapter(AbstractCustomCompanyProfileCommandJPARepository
                                                          companyProfileCommandCustomJPARepository,
                                                  AbstractDataAccessMapper<CompanyProfileEntity, CompanyProfileRoot>
                                                          companyProfileDataAccessMapper) {

        this.companyProfileCommandCustomJPARepository = companyProfileCommandCustomJPARepository;
        this.companyProfileDataAccessMapper = companyProfileDataAccessMapper;
    }

    @Override
    public Optional<CompanyProfileRoot> create(CompanyProfileRoot root) {
        var entity = this.companyProfileDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyProfileCommandCustomJPARepository.persist(entity.get());
            return this.companyProfileDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(CompanyProfileRoot root) {
        var entity = this.companyProfileDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyProfileCommandCustomJPARepository::update);
    }

    @Override
    public void inActive(CompanyProfileRoot root) {
        var entity = this.companyProfileDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyProfileCommandCustomJPARepository::inActive);
    }
}
