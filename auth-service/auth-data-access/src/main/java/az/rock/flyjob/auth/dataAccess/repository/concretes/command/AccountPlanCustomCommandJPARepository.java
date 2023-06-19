package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account.AbstractAccountPlanCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Component
public class AccountPlanCustomCommandJPARepository implements AbstractAccountPlanCommandJPARepository {
    protected Session session() {
        return entityManager.unwrap(Session.class);
    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public <S extends AccountPlanEntity> S persist(S entity) {
        var userId  = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userId);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> S persistAndFlush(S entity) {
        this.persist(entity);
        this.entityManager.flush();
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> persistAll(Iterable<S> entities) {
        return executeBatch(() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities) {
                result.add(this.persist(entity));
            }
            entityManager.flush();
            return result;
        });
    }

    @Override
    public <S extends AccountPlanEntity> List<S> persistAllAndFlush(Iterable<S> entities) {
        return executeBatch(() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities) {
                result.add(this.persist(entity));
            }
            entityManager.flush();
            return result;
        });
    }

    @Override
    public <S extends AccountPlanEntity> S merge(S entity) {
        return entityManager.merge(entity);
    }

    @Override
    public <S extends AccountPlanEntity> S mergeAndFlush(S entity) {
        S result = merge(entity);
        entityManager.flush();
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> mergeAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        for(S entity : entities)
            result.add(merge(entity));
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> mergeAllAndFlush(Iterable<S> entities) {
        return executeBatch(() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities) {
                result.add(merge(entity));
            }
            entityManager.flush();
            return result;
        });
    }

    @Override
    public <S extends AccountPlanEntity> S update(S entity) {
        this.session().merge(entity);
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> S updateAndFlush(S entity) {
        this.update(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> updateAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        for(S entity : entities)
            result.add(update(entity));
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> updateAllAndFlush(Iterable<S> entities) {
        return executeBatch(() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities)
                result.add(this.update(entity));
            entityManager.flush();
            return result;
        });
    }

    protected Integer getBatchSize(Session session) {
        try(var sessionFactory = session.getSessionFactory()
                .unwrap(SessionFactoryImplementor.class);) {
            final var jdbcServices = sessionFactory.getServiceRegistry()
                    .getService(JdbcServices.class);
            if(!jdbcServices.getExtractedMetaDataSupport().supportsBatchUpdates()) return Integer.MIN_VALUE;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return session.unwrap(AbstractSharedSessionContract.class)
                .getConfiguredJdbcBatchSize();
    }

    protected <R> R executeBatch(Supplier<R> callback) {
        Session session = this.session();
        Integer jdbcBatchSize = getBatchSize(session);
        Integer originalSessionBatchSize = session.getJdbcBatchSize();
        try {
            if (jdbcBatchSize == null) session.setJdbcBatchSize(10);
            return callback.get();
        } finally {
            session.setJdbcBatchSize(originalSessionBatchSize);
        }
    }
}
