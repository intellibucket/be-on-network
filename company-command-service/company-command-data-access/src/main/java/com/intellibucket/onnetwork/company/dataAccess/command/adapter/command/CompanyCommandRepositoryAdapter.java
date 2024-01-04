package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command;

import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.CompanyCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyCommandRepositoryAdapter implements AbstractCompanyCommandRepositoryAdapter {

    private final CompanyCommandJPARepository companyCommandJPARepository;

    private final AbstractCompanyDataAccessMapper companyDataAccessMapper;

    public CompanyCommandRepositoryAdapter(@Qualifier(value = "CompanyCommandJPARepository") CompanyCommandJPARepository companyCommandJPARepository,
                                           AbstractCompanyDataAccessMapper companyDataAccessMapper) {
        this.companyCommandJPARepository = companyCommandJPARepository;
        this.companyDataAccessMapper = companyDataAccessMapper;
    }


    @Override
    public Optional<CompanyRoot> create(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyCommandJPARepository.save(entity.get());
            return this.companyDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyCommandJPARepository::save);
    }

    @Override
    public void updateAll(List<CompanyRoot> roots) {
        var rootList = roots
                .stream()
                .map(this.companyDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.companyCommandJPARepository.saveAll(rootList);
    }

}
