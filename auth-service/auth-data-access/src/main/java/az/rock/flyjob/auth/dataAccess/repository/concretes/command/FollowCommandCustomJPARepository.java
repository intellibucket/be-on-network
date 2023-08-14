package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.EmailEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.network.AbstractFollowCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class FollowCommandCustomJPARepository implements AbstractFollowCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public <S extends FollowRelationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends FollowRelationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
