package az.rock.flyjob.auth.dataAccess.repository.concretes.query;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.UserQueryJPARepository;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserQueryRepositoryImpl implements UserQueryJPARepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserQueryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public UserType findUserTypeById(UUID userId) {
        UserEntity userEntity = this.findById(userId);
        return userEntity.getUserType();
    }

    @Override
    public UserEntity findByIdAndActiveRowStatus(UUID userId) {
        return this.entityManager.createQuery(
                "SELECT row FROM UserEntity row WHERE (:userId = row.uuid) " +
                        "and (row.rowStatus = 'ACTIVE')",
                        UserEntity.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    public UserEntity findById(UUID userId) {
        return this.entityManager.createQuery(
                        "SELECT row FROM UserEntity row WHERE (:userId = row.uuid) ",
                        UserEntity.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
