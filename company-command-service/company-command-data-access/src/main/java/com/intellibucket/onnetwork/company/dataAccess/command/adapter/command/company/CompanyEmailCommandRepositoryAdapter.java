package com.intellibucket.onnetwork.company.dataAccess.command.adapter.command.company;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.AbstractCustomCommandJPARepository;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyCommandJPARepository;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyEmailCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyEmailCommandRepositoryAdapter implements AbstractCompanyEmailCommandRepositoryAdapter {
    private final AbstractCustomCompanyEmailCommandJPARepository companyEmailCommandJPARepository;

    private final AbstractDataAccessMapper<EmailEntity, EmailRoot> companyEmailDataAccessMapper;

    public CompanyEmailCommandRepositoryAdapter(AbstractCustomCompanyEmailCommandJPARepository companyEmailCommandJPARepository,
                                           AbstractDataAccessMapper<EmailEntity, EmailRoot> companyEmailDataAccessMapper) {
        this.companyEmailCommandJPARepository = companyEmailCommandJPARepository;
        this.companyEmailDataAccessMapper = companyEmailDataAccessMapper;
    }

    @Override
    public Optional<EmailRoot> create(EmailRoot root) {
        var entity = this.companyEmailDataAccessMapper.toEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.companyEmailCommandJPARepository.persist(entity.get());
            return this.companyEmailDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(EmailRoot root) {
        var entity = this.companyEmailDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyEmailCommandJPARepository::update);
    }

    @Override
    public void inActive(EmailRoot root) {
        var entity = this.companyEmailDataAccessMapper.toEntity(root);
        entity.ifPresent(this.companyEmailCommandJPARepository::inActive);
    }
}
