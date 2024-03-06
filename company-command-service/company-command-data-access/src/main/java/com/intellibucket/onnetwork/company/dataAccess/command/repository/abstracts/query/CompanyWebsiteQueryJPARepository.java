package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyWebsiteQueryJPARepository extends JpaRepository<WebsiteEntity, UUID> {
//    @Query("SELECT w FROM WebsiteEntity w where w.company.uuid = :companyUuid and w.rowStatus = 'ACTIVE'")
    WebsiteEntity findWebsiteEntityByCompanyUuid(UUID companyUuid);
}
