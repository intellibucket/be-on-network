package com.intellibucket.onnetwork.company.dataAccess.command.repository.concretes.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyProfileCommandJPARepository;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyWebsiteCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomCompanyWebsiteCommandJPARepository implements AbstractCustomCompanyWebsiteCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends WebsiteEntity> S persist(S entity) {
        var companyEntityReference = this.entityManager.getReference(CompanyEntity.class, entity.getCompany().getUuid());
        entity.setCompany(companyEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends WebsiteEntity> S merge(S entity) {
        var companyEntityReference = this.entityManager.getReference(CompanyEntity.class, entity.getCompany().getUuid());
        entity.setCompany(companyEntityReference);
        this.entityManager.merge(entity);
        return entity;
    }
}
