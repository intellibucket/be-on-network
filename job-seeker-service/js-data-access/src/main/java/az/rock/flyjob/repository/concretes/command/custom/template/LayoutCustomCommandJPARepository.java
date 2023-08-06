package az.rock.flyjob.repository.concretes.command.custom.template;

import az.rock.flyjob.model.entity.resume.main.AddressEntity;
import az.rock.flyjob.model.entity.resume.template.LayoutEntity;
import az.rock.flyjob.repository.abstracts.command.custom.main.AbstractAddressCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.template.AbstractLayoutCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class LayoutCustomCommandJPARepository implements AbstractLayoutCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends LayoutEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends LayoutEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
