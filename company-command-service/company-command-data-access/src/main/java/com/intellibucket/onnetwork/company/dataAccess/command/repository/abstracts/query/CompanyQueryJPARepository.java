package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyQueryJPARepository extends JpaRepository<CompanyEntity, UUID> {
    @Query("SELECT c FROM CompanyEntity c where c.uuid = :companyId and c.rowStatus = 'ACTIVE'")
    CompanyEntity findCompanyEntity(@Param(value = "companyId") UUID companyId);
}
