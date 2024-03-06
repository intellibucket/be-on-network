package com.intellibucket.onnetwork.company.dataAccess.command.repository.concretes.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyProfileEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyEmailCommandJPARepository;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyProfileCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomCompanyProfileCommandJPARepository implements AbstractCustomCompanyProfileCommandJPARepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends CompanyProfileEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends CompanyProfileEntity> S merge(S entity) {
        var companyEntityReference = this.entityManager.getReference(CompanyEntity.class, entity.getCompany().getUuid());
        entity.setCompany(companyEntityReference);
        this.entityManager.merge(entity);
        return entity;
    }
}

