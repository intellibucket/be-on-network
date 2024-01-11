package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.CustomCommandJPARepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbstractCompanyCommandJPARepository extends CustomCommandJPARepository<CompanyEntity>  {
}
