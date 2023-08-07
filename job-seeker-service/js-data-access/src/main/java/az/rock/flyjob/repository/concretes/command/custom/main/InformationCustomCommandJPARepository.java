package az.rock.flyjob.repository.concretes.command.custom.main;

import az.rock.flyjob.model.entity.resume.main.AddressEntity;
import az.rock.flyjob.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.repository.abstracts.command.custom.main.AbstractAddressCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.main.AbstractInformationCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class InformationCustomCommandJPARepository implements AbstractInformationCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends InformationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends InformationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
