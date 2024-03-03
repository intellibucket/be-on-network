package com.intellibucket.lib.payload.event.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.SkillPayload;

public class SkillCreatedEvent extends AbstractStartDomainEvent<SkillPayload> {
    public SkillCreatedEvent(SkillPayload payload) {
        super(payload);
    }

    public static SkillCreatedEvent of(SkillPayload payload) {
        return new SkillCreatedEvent(payload);
    }
}
