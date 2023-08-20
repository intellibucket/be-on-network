package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.compose;

import az.rock.flyjob.auth.dataAccess.model.compose.UserSimpleCompose;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {

    Optional<UserSimpleCompose> findUserSimpleComposeByUserId(UUID userId);

}
