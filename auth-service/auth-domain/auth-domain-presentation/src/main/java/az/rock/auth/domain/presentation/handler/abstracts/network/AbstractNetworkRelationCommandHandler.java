package az.rock.auth.domain.presentation.handler.abstracts.network;

import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.payload.event.create.network.NetworkRelationEvent;

import java.util.UUID;

public interface AbstractNetworkRelationCommandHandler {
    NetworkRelationEvent handleSendRequest(UUID targetUserId);

    NetworkRelationEvent handleAcceptRequest(UUID relationUUID) throws NoActiveRowException;

    NetworkRelationEvent handleRejectRequest(UUID targetUserId) throws NoActiveRowException;

    NetworkRelationEvent handleCancelRequest(UUID targetUserId) throws NoActiveRowException;

    NetworkRelationEvent handleDeleteNetwork(UUID targetUserId) throws NoActiveRowException;


}
