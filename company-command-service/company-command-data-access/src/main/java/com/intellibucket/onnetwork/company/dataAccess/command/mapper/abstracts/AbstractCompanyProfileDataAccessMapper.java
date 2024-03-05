package com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts;

import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;

import java.util.Optional;
import java.util.UUID;

public interface AbstractCompanyProfileDataAccessMapper extends AbstractDataAccessMapper<CompanyProfileEntity, CompanyProfileRoot> {
}
