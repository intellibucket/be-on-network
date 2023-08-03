package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.compose;

import az.rock.flyjob.auth.dataAccess.model.compose.UserSimpleCompose;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface AbstractUserComposeQueryJPARepository  {

    //@Query(nativeQuery = true,name = "findUserSimpleComposeByUserId")
    Optional<UserSimpleCompose> findUserSimpleComposeByUserId(UUID userId);

}
