package com.intellibukcet.lib.payload.event.create.follow;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.event.create.user.payload.follow.FollowRelationPayload;


@Event
public class UnfollowRelationEvent extends AbstractDomainEvent<FollowRelationPayload> {
    protected UnfollowRelationEvent(FollowRelationPayload root) {
        super(root);
    }

    public static UnfollowRelationEvent of(FollowRelationPayload root) {
        return new UnfollowRelationEvent(root);
    }
}
