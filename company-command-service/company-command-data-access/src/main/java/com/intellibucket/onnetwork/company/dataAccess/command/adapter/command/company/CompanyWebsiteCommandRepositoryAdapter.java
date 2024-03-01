package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyWebsiteCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyProfileCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyWebsiteCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
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
        var entity = this.companyWebsiteDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyWebsiteCommandJPARepository.persist(entity.get());
            return this.companyWebsiteDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(WebsiteRoot root) {
        var entity = this.companyWebsiteDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyWebsiteCommandJPARepository::update);
    }

    @Override
    public void inActive(WebsiteRoot root) {
        var entity = this.companyWebsiteDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyWebsiteCommandJPARepository::inActive);
    }
}
