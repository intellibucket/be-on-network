package az.rock.flyjob.auth.dataAccess.repository.concretes.query;

import az.rock.flyjob.auth.dataAccess.model.compose.UserSimpleCompose;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.compose.AbstractUserComposeQueryJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
@Component
public class UserComposeQueryJPARepository   {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserComposeQueryJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Override
    public Optional<UserSimpleCompose> findUserSimpleComposeByUserId(UUID userId) {
        return Optional.empty();
    }
}
