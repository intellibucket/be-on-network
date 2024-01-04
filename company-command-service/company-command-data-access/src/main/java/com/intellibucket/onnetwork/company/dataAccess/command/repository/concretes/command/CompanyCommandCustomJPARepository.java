package com.intellibucket.onnetwork.company.dataAccess.command.repository.concretes.command;

import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCompanyCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CompanyCommandCustomJPARepository implements AbstractCompanyCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public <S extends CompanyEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends CompanyEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
