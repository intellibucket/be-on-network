package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.template;

import az.rock.flyjob.js.dataaccess.model.entity.resume.template.ResumeTemplateEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.template.AbstractResumeTemplateCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ResumeTemplateCustomCommandJPARepository implements AbstractResumeTemplateCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends ResumeTemplateEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ResumeTemplateEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
