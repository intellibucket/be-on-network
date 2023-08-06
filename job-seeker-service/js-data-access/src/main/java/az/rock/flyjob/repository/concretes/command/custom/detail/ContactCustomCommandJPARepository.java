package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.model.entity.resume.details.SkillEntity;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractContactCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractSkillCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ContactCustomCommandJPARepository implements AbstractContactCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends ContactEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ContactEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
