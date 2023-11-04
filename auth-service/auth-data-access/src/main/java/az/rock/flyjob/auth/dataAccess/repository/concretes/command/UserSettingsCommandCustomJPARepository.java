package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.settings.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user.AbstractUserSettingsCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSettingsCommandCustomJPARepository implements AbstractUserSettingsCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends UserSettingsEntity> S persist(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends UserSettingsEntity> S merge(S entity) {
        var userEntityReference = this.entityManager.getReference(UserEntity.class, entity.getUser().getUuid());
        entity.setUser(userEntityReference);
        return this.entityManager.merge(entity);
    }

    @Override
    public <S extends UserSettingsEntity> List<S> mergeAllAndFlush(Iterable<S> entities) {
        return AbstractUserSettingsCommandCustomJPARepository.super.mergeAllAndFlush(entities);
    }
}
