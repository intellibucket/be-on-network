package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractAwardCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractInterestCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class InterestCustomCommandJPARepository implements AbstractInterestCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends InterestEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends InterestEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
