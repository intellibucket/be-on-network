package com.intellibucket.lib.payload.event.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.CourseFilePayload;


@Event
public class CourseFileEvent extends AbstractStartDomainEvent<CourseFilePayload> {
    public CourseFileEvent() {}

    public CourseFileEvent(CourseFilePayload root) {
        super(root);
    }

    public static CourseFileEvent of(CourseFilePayload payload){
        return new CourseFileEvent(payload);
    }
}
