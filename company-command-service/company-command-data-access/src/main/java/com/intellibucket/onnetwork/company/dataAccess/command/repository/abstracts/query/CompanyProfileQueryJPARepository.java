package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CompanyProfileQueryJPARepository  extends JpaRepository<CompanyProfileEntity, UUID> {
    @Query("SELECT cp FROM CompanyProfileEntity cp where cp.company.uuid = :companyUuid and cp.rowStatus = 'ACTIVE'")
    CompanyProfileEntity findCompanyProfileEntityByCompanyUuid(UUID companyUuid);
}
