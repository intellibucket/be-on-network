package com.intellibucket.onnetwork.company.dataAccess.command.repository.concretes.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.EmailEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomCompanyEmailCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomCompanyEmailCommandJPARepository implements AbstractCustomCompanyEmailCommandJPARepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends EmailEntity> S persist(S entity) {
        var companyEntityReference = this.entityManager.getReference(CompanyEntity.class, entity.getCompany().getUuid());
        entity.setCompany(companyEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends EmailEntity> S merge(S entity) {
        var companyEntityReference = this.entityManager.getReference(CompanyEntity.class, entity.getCompany().getUuid());
        entity.setCompany(companyEntityReference);
        this.entityManager.merge(entity);
        return entity;
    }
}
