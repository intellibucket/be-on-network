package com.intellibucket.onnetwork.company.dataAccess.command.repository.concretes.command;

import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.AbstractCustomCommandJPARepository;
import com.intellibucket.onnetwork.company.dataAccess.command.repository.abstracts.command.AbstractCustomTestCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomCompanyTestJPARepository<T> implements AbstractCustomTestCommandJPARepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }


    @Override
    public <S extends T> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends T> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
