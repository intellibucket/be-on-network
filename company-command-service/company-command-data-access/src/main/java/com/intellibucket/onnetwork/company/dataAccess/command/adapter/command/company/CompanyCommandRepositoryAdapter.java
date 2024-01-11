package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCompanyCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyCommandRepositoryAdapter implements AbstractCompanyCommandRepositoryAdapter {
    private final AbstractCompanyCommandJPARepository companyCommandJPARepository;

    private final AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper;

    public CompanyCommandRepositoryAdapter(AbstractCompanyCommandJPARepository companyCommandJPARepository,
                                           AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper) {
        this.companyCommandJPARepository = companyCommandJPARepository;
        this.companyDataAccessMapper = companyDataAccessMapper;
    }

    @Override
    public Optional<CompanyRoot> create(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyCommandJPARepository.persist(entity.get());
            return this.companyDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyCommandJPARepository::update);
    }

    @Override
    public void inActive(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyCommandJPARepository::inActive);
    }
}
