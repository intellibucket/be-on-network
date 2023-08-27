package com.intellibukcet.lib.payload.event.create;

import com.intellibukcet.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibukcet.lib.payload.payload.ResumeCreatedPayload;


public class ResumeCreatedEvent extends AbstractSuccessDomainEvent<ResumeCreatedPayload> {
    public ResumeCreatedEvent(ResumeCreatedPayload payload) {
        super(payload);
    }

    public static ResumeCreatedEvent of(ResumeCreatedPayload payload){
        return new ResumeCreatedEvent(payload);
    }
}

