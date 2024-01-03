package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.command.AbstractCompanyCommandCustomJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyCommandRepositoryAdapter implements AbstractCompanyCommandRepositoryAdapter {

    private final AbstractCompanyCommandCustomJPARepository companyCommandCustomJPARepository;

    private final AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper;


    public CompanyCommandRepositoryAdapter(AbstractCompanyCommandCustomJPARepository companyCommandCustomJPARepository,
                                           AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper) {
        this.companyCommandCustomJPARepository = companyCommandCustomJPARepository;
        this.companyDataAccessMapper = companyDataAccessMapper;
    }


    @Override
    public Optional<CompanyRoot> create(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyCommandCustomJPARepository.persist(entity.get());
            return this.companyDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }
    @Override
    public void update(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyCommandCustomJPARepository::update);
    }

    @Override
    public void updateAll(List<CompanyRoot> roots) {
        var rootList = roots
                .stream()
                .map(this.companyDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.companyCommandCustomJPARepository.updateAll(rootList);
    }

    @Override
    public void inActive(CompanyRoot root) {
        var entity = this.companyDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyCommandCustomJPARepository::inActive);
    }
}
