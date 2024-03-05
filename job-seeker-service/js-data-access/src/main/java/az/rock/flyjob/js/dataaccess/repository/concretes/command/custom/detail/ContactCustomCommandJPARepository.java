package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractContactCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<ContactEntity> findById(UUID contactId) {
        return Optional.of(entityManager.find(ContactEntity.class, contactId));
    }

    @Override
    public void delete(ContactEntity contactEntity) {
        entityManager.remove(contactEntity);
    }
}
