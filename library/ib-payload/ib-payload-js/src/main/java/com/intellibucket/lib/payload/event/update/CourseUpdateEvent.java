package com.intellibucket.lib.payload.event.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.CourseUpdatedPayload;

@Event
public class CourseUpdateEvent extends AbstractSuccessDomainEvent<CourseUpdatedPayload> {
    public CourseUpdateEvent(CourseUpdatedPayload payload) {
        super(payload);
    }

    public static CourseUpdateEvent of(CourseUpdatedPayload payload){
        return new CourseUpdateEvent(payload);
    }
}
