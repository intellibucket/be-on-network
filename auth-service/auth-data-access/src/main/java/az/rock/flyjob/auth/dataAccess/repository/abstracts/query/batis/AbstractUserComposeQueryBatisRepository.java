package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis;

import az.rock.flyjob.auth.dataAccess.model.compose.user.UserCompose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {
    UserCompose findUserProfileComposeByUserId(@Param(value = "userId") UUID userId);

}
