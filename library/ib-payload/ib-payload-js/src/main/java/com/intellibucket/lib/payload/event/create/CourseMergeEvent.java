package com.intellibucket.lib.payload.event.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.CourseMergePayload;


@Event
public class CourseMergeEvent extends AbstractSuccessDomainEvent<CourseMergePayload> {
    public CourseMergeEvent(CourseMergePayload payload) {
        super(payload);
    }

    public static CourseMergeEvent of(CourseMergePayload payload){
        return new CourseMergeEvent(payload);
    }
}
