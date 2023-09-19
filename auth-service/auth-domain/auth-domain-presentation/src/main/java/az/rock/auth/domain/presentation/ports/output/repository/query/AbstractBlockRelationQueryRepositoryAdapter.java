package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;
import java.util.UUID;

@DomainOutputPort
public interface AbstractBlockRelationQueryRepositoryAdapter {

    List<BlockRelationRoot> findMyBlockedList(UserID userID);

    List<BlockRelationRoot> findWhoBlockedMe(UUID targetUserId);

    List<BlockRelationRoot> isPresentInMyBlockedList(UUID currentUserId, UUID targetUserId);

    Boolean unblockTargetUserAgain(UUID currentUserId, UUID targetUserId);

    Boolean blockRelationByUsers(UUID currentUserId, UUID targetUserId);

}
