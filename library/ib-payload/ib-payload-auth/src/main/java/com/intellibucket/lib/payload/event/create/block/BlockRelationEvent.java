package com.intellibucket.lib.payload.event.create.block;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.create.user.payload.block.BlockRelationPayload;

@Event
public class BlockRelationEvent extends AbstractDomainEvent<BlockRelationPayload> {

    protected BlockRelationEvent(BlockRelationPayload payload) {
        super(payload);
    }

    public static BlockRelationEvent of(BlockRelationPayload payload) {
        return new BlockRelationEvent(payload);
    }
}
