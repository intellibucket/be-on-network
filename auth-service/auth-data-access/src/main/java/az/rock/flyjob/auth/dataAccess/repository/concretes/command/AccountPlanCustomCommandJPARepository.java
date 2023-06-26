package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account.AbstractAccountPlanCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountPlanCustomCommandJPARepository implements AbstractAccountPlanCommandJPARepository {

    @PersistenceContext
    private EntityManager entityManager;


    protected Session session() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public void flush() {
        this.entityManager.flush();
    }

    @Override
    public <S extends AccountPlanEntity> S persist(S entity) {
        var userEntityReference  = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> S persistAndFlush(S entity) {
        this.persist(entity);
        this.flush();
        return entity;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> persistAll(Iterable<S> entities) {
        return this.executeBatch(this.session(),() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities) {
                result.add(this.persist(entity));
            }
            return result;
        });
    }

    @Override
    public <S extends AccountPlanEntity> List<S> persistAllAndFlush(Iterable<S> entities) {
        return this.executeBatch(this.session(),() -> {
            List<S> result = new ArrayList<>();
            for(S entity : entities) {
                result.add(this.persist(entity));
            }
            this.flush();
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
        this.flush();
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> mergeAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(this.merge(entity)));
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> mergeAllAndFlush(Iterable<S> entities) {
        return this.executeBatch(this.session(),() -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.merge(entity)));
            this.flush();
            return result;
        });
    }

    @Override
    public <S extends AccountPlanEntity> S update(S entity) {
        return this.session().merge(entity);
    }

    @Override
    public <S extends AccountPlanEntity> S updateAndFlush(S entity) {
        var updatedEntity = this.update(entity);
        this.flush();
        return updatedEntity;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> updateAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(this.update(entity)));
        return result;
    }

    @Override
    public <S extends AccountPlanEntity> List<S> updateAllAndFlush(Iterable<S> entities) {
       var list = this.updateAll(entities);
       this.flush();
       return list;
    }

}
