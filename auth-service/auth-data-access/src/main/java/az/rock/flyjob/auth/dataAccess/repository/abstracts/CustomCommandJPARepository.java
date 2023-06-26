package az.rock.flyjob.auth.dataAccess.repository.abstracts;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@NoRepositoryBean
public interface CustomCommandJPARepository<T> {

    EntityManager entityManager();

    default Session session(){
        return this.entityManager().unwrap(Session.class);
    }
    default void flush(){
        this.entityManager().flush();
    }

    <S extends T > S persist(S entity);

    default <S extends T> S persistAndFlush(S entity){
        var savedEntity = this.persist(entity);
        this.flush();
        return savedEntity;
    }

    default <S extends T> List<S> persistAll(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.persist(entity)));
            return result;
        });
    }

    default <S extends T> List<S> persistAllAndFlush(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.persist(entity)));
            this.flush();
            return result;
        });
    }

    <S extends T> S merge(S entity);

    default <S extends T> S mergeAndFlush(S entity){
        var savedEntity = this.merge(entity);
        this.flush();
        return savedEntity;
    }

    default <S extends T> List<S> mergeAll(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.merge(entity)));
            return result;
        });
    }

    default <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.merge(entity)));
            this.flush();
            return result;
        });
    }

    default <S extends T> S update(S entity){
        return this.merge(entity);
    }

    default <S extends T> S updateAndFlush(S entity){
        return this.mergeAndFlush(entity);
    }

    default <S extends T> List<S> updateAll(Iterable<S> entities){
        return this.mergeAll(entities);
    }

    default <S extends T> List<S> updateAllAndFlush(Iterable<S> entities){
        return this.mergeAllAndFlush(entities);
    }

    default Integer getBatchSize(Session session) {
        try(var sessionFactory = session.getSessionFactory().unwrap(SessionFactoryImplementor.class);) {
            final var jdbcServices = sessionFactory.getServiceRegistry().getService(JdbcServices.class);
            var isSupportsBatchUpdates = jdbcServices.getExtractedMetaDataSupport().supportsBatchUpdates();
            if(!isSupportsBatchUpdates) return Integer.MIN_VALUE;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return session.unwrap(AbstractSharedSessionContract.class).getConfiguredJdbcBatchSize();
    }

    default  <R> R executeBatch(Session session,Supplier<R> callback) {
        Integer jdbcBatchSize = this.getBatchSize(session);
        Integer originalSessionBatchSize = session.getJdbcBatchSize();
        try {
            if (jdbcBatchSize == null) session.setJdbcBatchSize(10);
            return callback.get();
        } finally {
            session.setJdbcBatchSize(originalSessionBatchSize);
        }
    }
}