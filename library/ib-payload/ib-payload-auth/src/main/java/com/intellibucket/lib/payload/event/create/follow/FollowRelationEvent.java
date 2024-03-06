package com.intellibucket.lib.payload.event.create.follow;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.create.user.payload.follow.FollowRelationPayload;

@Event
public class FollowRelationEvent extends AbstractDomainEvent<FollowRelationPayload> {

    protected FollowRelationEvent(FollowRelationPayload payload) {
        super(payload);
    }

    public static FollowRelationEvent of(FollowRelationPayload payload) {
        return new FollowRelationEvent(payload);
    }
}