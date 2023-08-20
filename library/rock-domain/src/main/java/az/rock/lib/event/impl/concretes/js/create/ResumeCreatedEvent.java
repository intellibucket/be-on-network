package az.rock.lib.event.impl.concretes.js.create;

import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.payload.js.ResumeCreatedPayload;

public class ResumeCreatedEvent extends AbstractSuccessDomainEvent<ResumeCreatedPayload> {
    public ResumeCreatedEvent(ResumeCreatedPayload payload) {
        super(payload);
    }

    public static ResumeCreatedEvent of(ResumeCreatedPayload payload){
        return new ResumeCreatedEvent(payload);
    }
}
