package com.intellibukcet.lib.payload.event.create.follow;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.event.create.user.payload.follow.FollowRelationPayload;

@Event
public class FollowRelationEvent extends AbstractDomainEvent<FollowRelationPayload> {

    protected FollowRelationEvent(FollowRelationPayload payload) {
        super(payload);
    }

    public static FollowRelationEvent of(FollowRelationPayload payload) {
        return new FollowRelationEvent(payload);
    }
}