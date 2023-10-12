package az.rock.auth.domain.presentation.handler.abstracts.network;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import com.intellibukcet.lib.payload.event.create.network.NetworkRelationEvent;

import java.util.UUID;

public interface AbstractNetworkRelationCommandHandler {
    NetworkRelationEvent handleSendRequest(UUID targetUserId);

    NetworkRelationEvent handleAcceptRequest(UUID targetUserId);

    NetworkRelationEvent handleRejectRequest(UUID targetUserId);

    NetworkRelationEvent handleCancelRequest(UUID targetUserId);

    NetworkRelationEvent handleDeleteNetwork(UUID targetUserId);


}
