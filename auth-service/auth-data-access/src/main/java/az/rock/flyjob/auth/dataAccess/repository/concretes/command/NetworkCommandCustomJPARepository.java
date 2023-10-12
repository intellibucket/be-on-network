package az.rock.flyjob.auth.dataAccess.repository.concretes.command;

import az.rock.flyjob.auth.dataAccess.model.entity.network.BlockRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.network.FollowRelationEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.network.NetworkRelationEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractFollowRelationCommandCustomJPARepository;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractNetworkRelationCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class NetworkCommandCustomJPARepository implements AbstractNetworkRelationCommandJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public <S extends NetworkRelationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends NetworkRelationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
