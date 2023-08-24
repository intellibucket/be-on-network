package com.intellibukcet.lib.payload.event.create;

import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.payload.js.ResumeCreatedPayload;


public class ResumeCreatedEvent extends AbstractSuccessDomainEvent<ResumeCreatedPayload> {
    public ResumeCreatedEvent(ResumeCreatedPayload payload) {
        super(payload);
    }

    public static az.rock.lib.event.impl.concretes.js.create.ResumeCreatedEvent of(ResumeCreatedPayload payload){
        return new az.rock.lib.event.impl.concretes.js.create.ResumeCreatedEvent(payload);
    }
}

