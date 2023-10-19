package com.intellibukcet.lib.payload.event.create.network;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.event.create.follow.FollowRelationEvent;
import com.intellibukcet.lib.payload.event.create.user.payload.follow.FollowRelationPayload;
import com.intellibukcet.lib.payload.event.create.user.payload.network.NetworkRelationPayload;

@Event
public class NetworkRelationEvent extends AbstractDomainEvent<NetworkRelationPayload> {
    protected NetworkRelationEvent(NetworkRelationPayload payload) {
        super(payload);
    }

    public static NetworkRelationEvent of(NetworkRelationPayload payload) {
        return new NetworkRelationEvent(payload);
    }
}
