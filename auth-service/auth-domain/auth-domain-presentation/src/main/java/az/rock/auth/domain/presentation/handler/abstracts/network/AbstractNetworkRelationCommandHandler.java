package az.rock.auth.domain.presentation.handler.abstracts.network;

import com.intellibucket.lib.payload.event.create.network.NetworkRelationEvent;

import java.util.UUID;

public interface AbstractNetworkRelationCommandHandler {
    NetworkRelationEvent handleSendRequest(UUID targetUserId);

    NetworkRelationEvent handleAcceptRequest(UUID relationUUID);

    NetworkRelationEvent handleRejectRequest(UUID targetUserId);

    NetworkRelationEvent handleCancelRequest(UUID targetUserId);

    NetworkRelationEvent handleDeleteNetwork(UUID targetUserId);


}
