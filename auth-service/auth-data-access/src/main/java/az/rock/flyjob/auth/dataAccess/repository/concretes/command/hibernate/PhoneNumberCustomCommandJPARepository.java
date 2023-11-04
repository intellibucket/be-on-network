package az.rock.flyjob.auth.dataAccess.repository.concretes.command.hibernate;

import az.rock.flyjob.auth.dataAccess.model.entity.user.PhoneNumberEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractPhoneNumberCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberCustomCommandJPARepository implements AbstractPhoneNumberCommandJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends PhoneNumberEntity> S persist(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends PhoneNumberEntity> S merge(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        return this.entityManager.merge(entity);
    }

}
