package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email.AbstractEmailCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class EmailCommandCustomJPARepository implements AbstractEmailCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Session session() {
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
    public <S extends EmailEntity> S merge(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        return this.entityManager.merge(entity);
    }

}
