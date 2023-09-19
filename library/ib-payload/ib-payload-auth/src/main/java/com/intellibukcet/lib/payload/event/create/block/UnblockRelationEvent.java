package com.intellibukcet.lib.payload.event.create.block;

import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.event.create.user.payload.block.BlockRelationPayload;

@Event
public class UnblockRelationEvent extends AbstractDomainEvent<BlockRelationPayload> {

    protected UnblockRelationEvent(BlockRelationPayload payload) {
        super(payload);
    }

    public static UnblockRelationEvent of(BlockRelationPayload payload) {
        return new UnblockRelationEvent(payload);
    }
}
