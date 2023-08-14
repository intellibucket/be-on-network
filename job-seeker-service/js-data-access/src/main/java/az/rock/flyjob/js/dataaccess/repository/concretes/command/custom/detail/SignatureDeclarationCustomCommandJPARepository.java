package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.SignatureDeclarationEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractSignatureDeclarationCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class SignatureDeclarationCustomCommandJPARepository implements AbstractSignatureDeclarationCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends SignatureDeclarationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends SignatureDeclarationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
