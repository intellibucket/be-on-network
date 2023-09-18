package com.intellibukcet.lib.payload.event.create.block;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.event.create.follow.FollowRelationEvent;
import com.intellibukcet.lib.payload.event.create.user.payload.block.BlockRelationPayload;
import com.intellibukcet.lib.payload.event.create.user.payload.follow.FollowRelationPayload;

@Event
public class BlockRelationEvent extends AbstractDomainEvent<BlockRelationPayload> {

    protected BlockRelationEvent(BlockRelationPayload payload) {
        super(payload);
    }

    public static BlockRelationEvent of(BlockRelationPayload payload) {
        return new BlockRelationEvent(payload);
    }
}
