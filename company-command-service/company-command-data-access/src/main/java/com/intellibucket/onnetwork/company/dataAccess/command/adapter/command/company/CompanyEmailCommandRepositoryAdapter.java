package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyEmailCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CompanyEmailCommandRepositoryAdapter implements AbstractCompanyEmailCommandRepositoryAdapter {
    private final AbstractCustomCompanyEmailCommandJPARepository companyEmailCommandCustomJPARepository;

    private final AbstractDataAccessMapper<EmailEntity, EmailRoot> companyEmailDataAccessMapper;

    public CompanyEmailCommandRepositoryAdapter(AbstractCustomCompanyEmailCommandJPARepository companyEmailCommandCustomJPARepository,
                                                AbstractDataAccessMapper<EmailEntity, EmailRoot> companyEmailDataAccessMapper) {
        this.companyEmailCommandCustomJPARepository = companyEmailCommandCustomJPARepository;
        this.companyEmailDataAccessMapper = companyEmailDataAccessMapper;
    }


    @Override
    public Optional<EmailRoot> create(EmailRoot root) {
        var optionalEntity = this.companyEmailDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            var savedEntity = this.companyEmailCommandCustomJPARepository.persist(entity);
            log.info("Entity saved successfully: {}", savedEntity.getUuid());
            return this.companyEmailDataAccessMapper.toRoot(savedEntity);
        }else{
            log.warn("Entity is absent. Handle this case: {}", root.getRootID());
            return Optional.empty();
        }
    }

    @Override
    public void update(EmailRoot root) {
        this.companyEmailDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyEmailCommandCustomJPARepository.update(updatedEntity);
                            log.info("Entity updated successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );

    }

    @Override
    public void inActive(EmailRoot root) {
        this.companyEmailDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyEmailCommandCustomJPARepository.inActive(updatedEntity);
                            log.info("Entity inactive successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );
    }
    @Override
    public void updateAll(List<EmailRoot> emails) {
        List<EmailEntity> entityList = emails.stream()
                .map(this.companyEmailDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        companyEmailCommandCustomJPARepository.updateAll(entityList);
    }
}
