package az.rock.flyjob.auth.dataAccess.repository.abstracts;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.function.Supplier;

@NoRepositoryBean
public interface BaseCustomRepository<T> {

    /*
        The persist methods are meant to save the newly created entities.
    */

    void flush();

    <S extends T> S persist(S entity);

    default <S extends T> S persistAndFlush(S entity){
        var savedEntity = this.persist(entity);
        this.flush();
        return savedEntity;
    }



    <S extends T> List<S> persistAll(Iterable<S> entities);

    <S extends T> List<S> persistAllAndFlush(Iterable<S> entities);

    /*
        The merge methods are meant to propagate detached entity state changes
        if they are really needed.
    */

    <S extends T> S merge(S entity);

    <S extends T> S mergeAndFlush(S entity);

    <S extends T> List<S> mergeAll(Iterable<S> entities);

    <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities);

    /*
        The update methods are meant to force the synchronization of the
        detached entity state changes.
    */

    default <S extends T> S update(S entity){
        return merge(entity);
    }

    default <S extends T> S updateAndFlush(S entity){
        return mergeAndFlush(entity);
    }

    default <S extends T> List<S> updateAll(Iterable<S> entities){
        return mergeAll(entities);
    }

    default <S extends T> List<S> updateAllAndFlush(Iterable<S> entities){
        return mergeAllAndFlush(entities);
    }

    default Integer getBatchSize(Session session) {
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

    default  <R> R executeBatch(Session session,Supplier<R> callback) {
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