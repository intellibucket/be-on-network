package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.main;

import az.rock.flyjob.js.dataaccess.model.entity.resume.main.JobTitleInformationEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.main.AbstractJobTitleInformationCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class JobTitleInformationCustomCommandJPARepository implements AbstractJobTitleInformationCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends JobTitleInformationEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends JobTitleInformationEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
