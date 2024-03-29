package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.command.ResumeCreatedPayload;


public class ResumeCreatedEvent extends AbstractSuccessDomainEvent<ResumeCreatedPayload> {
    public ResumeCreatedEvent(ResumeCreatedPayload payload) {
        super(payload);
    }

    public static ResumeCreatedEvent of(ResumeCreatedPayload payload){
        return new ResumeCreatedEvent(payload);
    }
}

