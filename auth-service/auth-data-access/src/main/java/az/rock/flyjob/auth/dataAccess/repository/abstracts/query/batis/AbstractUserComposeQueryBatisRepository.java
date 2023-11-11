package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis;

import az.rock.flyjob.auth.dataAccess.model.compose.user.UserCompose;
import az.rock.flyjob.auth.dataAccess.model.query.UserProfileQueryRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {
    UserProfileQueryRecord findUserProfileById(@Param(value = "userId") UUID userId);

}
