package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyEmailDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyEmailDataAccessMapper implements AbstractCompanyEmailDataAccessMapper {
    @Override
    public Optional<EmailRoot> toRoot(EmailEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<EmailEntity> toEntity(EmailRoot root) {
        return Optional.empty();
    }
}
