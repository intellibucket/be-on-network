package az.rock.flyjob.auth.dataAccess.repository.concretes.command.ch;

import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractBlockRelationCommandCustomJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class BlockRelationCustomCommandJPARepository implements AbstractBlockRelationCommandCustomJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public <S extends BlockRelationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends BlockRelationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
