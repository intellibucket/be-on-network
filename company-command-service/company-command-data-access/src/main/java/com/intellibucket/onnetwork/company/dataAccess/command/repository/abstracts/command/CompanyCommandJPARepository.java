package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyCommandJPARepository extends JpaRepository<CompanyEntity, UUID> {
}
