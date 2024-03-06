package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CompanyCommandRepositoryAdapter implements AbstractCompanyCommandRepositoryAdapter {
    private final AbstractCustomCompanyCommandJPARepository companyCommandJPARepository;

    private final AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper;

    public CompanyCommandRepositoryAdapter(AbstractCustomCompanyCommandJPARepository companyCommandJPARepository,
                                           AbstractDataAccessMapper<CompanyEntity, CompanyRoot> companyDataAccessMapper) {
        this.companyCommandJPARepository = companyCommandJPARepository;
        this.companyDataAccessMapper = companyDataAccessMapper;
    }


    @Override
    public Optional<CompanyRoot> create(CompanyRoot root) {
        var optionalEntity = this.companyDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            var savedEntity = this.companyCommandJPARepository.persist(entity);
            log.info("Entity saved successfully: {}", savedEntity.getUuid());
            return this.companyDataAccessMapper.toRoot(savedEntity);
        }else{
            log.warn("Entity is absent. Handle this case: {}", root.getRootID());
            return Optional.empty();
        }
    }

    @Override
    public void update(CompanyRoot root) {
        this.companyDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyCommandJPARepository.update(updatedEntity);
                            log.info("Entity updated successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );

    }

    @Override
    public void inActive(CompanyRoot root) {
        this.companyDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyCommandJPARepository.inActive(updatedEntity);
                            log.info("Entity inactive successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );
    }
}
