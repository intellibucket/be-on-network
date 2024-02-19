package com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.query;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CompanyEmailQueryJPARepository extends JpaRepository<EmailEntity, UUID> {

    @Query("SELECT e FROM EmailEntity e where e.company.uuid = :companyUuid and e.rowStatus = 'ACTIVE'")
    EmailEntity findEmailEntityByCompanyUuid(UUID companyUuid);

    @Query("SELECT COUNT (e) > 0 FROM EmailEntity e WHERE e.email = :email and e.rowStatus = 'ACTIVE'")
    Boolean existsByEmail(String email);

    @Query("SELECT e FROM EmailEntity e WHERE e.company.uuid = :companyId and e.rowStatus = 'ACTIVE'")
    List<EmailEntity> findAllByCompanyId(UUID companyId);

    @Query("SELECT e FROM EmailEntity e WHERE e.uuid = :emailId and e.rowStatus = 'ACTIVE'")
    EmailEntity findEmailById(UUID emailId);

    @Query("SELECT e FROM EmailEntity e WHERE e.company.uuid = :companyUUID and e.rowStatus = 'ACTIVE' " +
            "order by e.createdDate desc limit 1")
    EmailEntity findFirstEmailByCreatedDate(UUID companyUUID);


}
