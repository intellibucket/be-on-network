package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyWebsiteCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyProfileCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyWebsiteCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CompanyWebsiteCommandRepositoryAdapter implements AbstractCompanyWebsiteCommandRepositoryAdapter {

    private final AbstractCustomCompanyWebsiteCommandJPARepository companyWebsiteCommandJPARepository;

    private final AbstractDataAccessMapper<WebsiteEntity, WebsiteRoot> companyWebsiteDataAccessMapper;

    public CompanyWebsiteCommandRepositoryAdapter(AbstractCustomCompanyWebsiteCommandJPARepository
                                                          companyWebsiteCommandJPARepository,
                                                  AbstractDataAccessMapper<WebsiteEntity, WebsiteRoot>
                                                          companyWebsiteDataAccessMapper) {
        this.companyWebsiteCommandJPARepository = companyWebsiteCommandJPARepository;
        this.companyWebsiteDataAccessMapper = companyWebsiteDataAccessMapper;
    }


    @Override
    public Optional<WebsiteRoot> create(WebsiteRoot root) {
        var optionalEntity = this.companyWebsiteDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            var savedEntity = this.companyWebsiteCommandJPARepository.persist(entity);
            log.info("Entity saved successfully: {}", savedEntity.getUuid());
            return this.companyWebsiteDataAccessMapper.toRoot(savedEntity);
        }else{
            log.warn("Entity is absent. Handle this case: {}", root.getRootID());
            return Optional.empty();
        }
    }

    @Override
    public void update(WebsiteRoot root) {
        this.companyWebsiteDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyWebsiteCommandJPARepository.update(updatedEntity);
                            log.info("Entity updated successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );

    }

    @Override
    public void inActive(WebsiteRoot root) {
        this.companyWebsiteDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        updatedEntity -> {
                            this.companyWebsiteCommandJPARepository.inActive(updatedEntity);
                            log.info("Entity inactive successfully: {} ", updatedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );
    }

    @Override
    public void delete(WebsiteRoot root) {
        this.companyWebsiteDataAccessMapper.toEntity(root)
                .ifPresentOrElse(
                        deletedEntity -> {
                            this.companyWebsiteCommandJPARepository.delete(deletedEntity);
                            log.info("Entity deleted successfully: {} ", deletedEntity.getUuid());
                        },
                        () -> log.warn("Entity is absent. Handle this case.{}",root.getRootID())
                );    }
}
