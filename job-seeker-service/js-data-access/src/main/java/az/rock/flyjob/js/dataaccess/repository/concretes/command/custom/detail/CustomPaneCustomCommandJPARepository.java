package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CustomPaneEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCustomPaneCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomPaneCustomCommandJPARepository implements AbstractCustomPaneCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends CustomPaneEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends CustomPaneEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
