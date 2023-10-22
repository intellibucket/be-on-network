package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis;

import az.rock.flyjob.auth.dataAccess.model.compose.UserSimpleCompose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;
import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {


    UserSimpleCompose findUserSimpleComposeByUserId(@Param(value = "userId") UUID userId);

}
