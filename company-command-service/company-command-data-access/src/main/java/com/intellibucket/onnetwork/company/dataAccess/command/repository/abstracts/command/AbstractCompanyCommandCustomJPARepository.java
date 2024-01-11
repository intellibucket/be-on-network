package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.CustomCommandJPARepository;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

public interface AbstractCompanyCommandCustomJPARepository extends CustomCommandJPARepository<CompanyEntity> {
}
