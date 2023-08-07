package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractCourseCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CouserCustomCommandJPARepository implements AbstractCourseCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends CourseEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends CourseEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
