package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email.AbstractEmailCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailCommandCustomJPARepository implements AbstractEmailCommandCustomJPARepository {

    @PersistenceContext
    private final EntityManager entityManager;


    public EmailCommandCustomJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected Session session() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public void flush() {
        this.entityManager.flush();
    }

    @Override
    public <S extends EmailEntity> S persist(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends EmailEntity> S persistAndFlush(S entity) {
        var savedEntity = this.persist(entity);
        this.flush();
        return savedEntity;
    }

    @Override
    public <S extends EmailEntity> List<S> persistAll(Iterable<S> entities) {
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            for (S entity : entities) {
                result.add(this.persist(entity));
            }
            return result;
        });
    }

    @Override
    public <S extends EmailEntity> List<S> persistAllAndFlush(Iterable<S> entities) {
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            for (S entity : entities) {
                result.add(this.persist(entity));
            }
            this.flush();
            return result;
        });
    }

    @Override
    public <S extends EmailEntity> S merge(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        return this.entityManager.merge(entity);
    }

    @Override
    public <S extends EmailEntity> S mergeAndFlush(S entity) {
        var mergedEntity = this.merge(entity);
        this.flush();
        return mergedEntity;
    }

    @Override
    public <S extends EmailEntity> List<S> mergeAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(this.merge(entity)));
        return result;
    }

    @Override
    public <S extends EmailEntity> List<S> mergeAllAndFlush(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(this.mergeAndFlush(entity)));
        return result;
    }

}
