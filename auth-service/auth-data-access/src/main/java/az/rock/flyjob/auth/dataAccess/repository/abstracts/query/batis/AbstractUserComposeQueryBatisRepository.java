package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis;

import az.rock.auth.domain.presentation.dto.response.user.SimpleAnyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleFollowerUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleNetworkUserResponse;
import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import az.rock.lib.valueObject.common.PageableRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;


@Mapper
public interface AbstractUserComposeQueryBatisRepository {
    MyProfileQueryRecord findUserProfileById(
            @Param(value = "userId") UUID userId
    );

    AnyProfileQueryRecord findAnyUserProfileById(
            @Param(value = "authId") UUID authenticatedUserId,
            @Param(value = "targetId")  UUID targetUserId
    );

    List<SimpleAnyUserProfileResponse> findAllAnyUserProfilesByIds(
            @Param(value = "authId") UUID authenticatedUserId,
            @Param(value = "targetIdList") List<UUID> targetUserIds
    );

    List<SimpleFollowerUserResponse> findAllMyFollowers(
            @Param(value = "authId") UUID authenticatedUserId,
            @Param(value = "pageable") PageableRequest pageable);

    List<SimpleNetworkUserResponse> findAllMyNetworks(
            @Param(value = "authId") UUID authenticatedUserId,
            @Param(value = "pageable") PageableRequest pageable);
}
