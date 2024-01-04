package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractCompanyProfileDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyProfileDataAccessMapper implements AbstractCompanyProfileDataAccessMapper {
    @Override
    public Optional<CompanyProfileRoot> toRoot(CompanyProfileEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<CompanyProfileEntity> toEntity(CompanyProfileRoot root) {
        return Optional.empty();
    }
}
