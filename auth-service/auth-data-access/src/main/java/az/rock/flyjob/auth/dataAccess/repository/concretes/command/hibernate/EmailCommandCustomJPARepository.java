package az.rock.flyjob.auth.dataAccess.repository.concretes.command.hibernate;

import az.rock.flyjob.auth.dataAccess.model.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email.AbstractEmailCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class EmailCommandCustomJPARepository implements AbstractEmailCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends EmailEntity> S persist(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends EmailEntity> S merge(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        return this.entityManager.merge(entity);
    }

}
