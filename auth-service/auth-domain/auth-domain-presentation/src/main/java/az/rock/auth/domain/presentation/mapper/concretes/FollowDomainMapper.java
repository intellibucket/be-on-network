package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractFollowDomainMapper;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FollowDomainMapper implements AbstractFollowDomainMapper {

    @Override
    public FollowRelationRoot toNewFollowRelationRoot(UserIdTypePair userID, UserIdTypePair followUserID) {
        return FollowRelationRoot.Builder
                .builder()
                .followID(FollowID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .followingUserType(followUserID.getUserType())
                .followingUserId(followUserID.getUserID().getAbsoluteID())
                .followerUserType(userID.getUserType())
                .followedUserId(userID.getUserID().getAbsoluteID())
                .followStatus(FollowStatus.ACCEPTED)
                .blockReasonStatus(BlockReasonStatus.UNKNOWN)

                .build();
    }
}

