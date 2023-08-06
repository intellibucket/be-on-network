package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.repository.abstracts.command.custom.AbstractResumeCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractAwardCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class AwardCustomCommandJPARepository implements AbstractAwardCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends AwardEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends AwardEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
