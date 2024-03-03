package com.intellibucket.lib.payload.event.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.CourseCreatedPayload;


@Event
public class CourseCreatedEvent extends AbstractSuccessDomainEvent<CourseCreatedPayload> {
    public CourseCreatedEvent(CourseCreatedPayload payload) {
        super(payload);
    }

    public static CourseCreatedEvent of(CourseCreatedPayload payload){
        return new CourseCreatedEvent(payload);
    }
}
