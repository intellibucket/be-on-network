package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyProfileCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyProfileCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
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
        var optionalEntity = this.companyProfileDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            var savedEntity = this.companyProfileCommandCustomJPARepository.persist(entity);
            log.info("Entity saved successfully: {}", savedEntity.getUuid());
            return this.companyProfileDataAccessMapper.toRoot(savedEntity);
        }else{
            log.warn("Entity is absent. Handle this case: {}", root.getRootID());
            return Optional.empty();
        }
    }

    @Override
    public void update(CompanyProfileRoot root) {
        this.companyProfileDataAccessMapper.toEntity(root)
        .ifPresentOrElse(
                updatedEntity -> {
                    this.companyProfileCommandCustomJPARepository.update(updatedEntity);
                    log.info("Entity updated successfully: {} ", updatedEntity.getUuid());
                },
                () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
        );

    }

    @Override
    public void inActive(CompanyProfileRoot root) {
        this.companyProfileDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyProfileCommandCustomJPARepository.inActive(updatedEntity);
                            log.info("Entity inactive successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );
    }
}
