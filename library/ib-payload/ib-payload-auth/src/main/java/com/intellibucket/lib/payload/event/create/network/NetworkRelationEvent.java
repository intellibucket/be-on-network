package com.intellibucket.lib.payload.event.create.network;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.create.user.payload.network.NetworkRelationPayload;

@Event
public class NetworkRelationEvent extends AbstractDomainEvent<NetworkRelationPayload> {
    protected NetworkRelationEvent(NetworkRelationPayload payload) {
        super(payload);
    }

    public static NetworkRelationEvent of(NetworkRelationPayload payload) {
        return new NetworkRelationEvent(payload);
    }
}
