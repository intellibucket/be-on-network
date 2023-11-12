package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis;

import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {
    MyProfileQueryRecord findUserProfileById(@Param(value = "userId") UUID userId);

    AnyProfileQueryRecord findAnyUserProfileById(@Param(value = "authId") UUID authenticatedUserId,@Param(value = "targetId")  UUID targetUserId);
}
