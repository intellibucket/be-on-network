package com.intellibucket.lib.payload.event.create;


import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.EducationPayload;

public class EducationCreatedEvent extends AbstractStartDomainEvent<EducationPayload> {

    public EducationCreatedEvent() {

    }

    private EducationCreatedEvent(EducationPayload root) {
        super(root);
    }

    public static EducationCreatedEvent of(EducationPayload root) {
        return new EducationCreatedEvent(root);
    }

}

