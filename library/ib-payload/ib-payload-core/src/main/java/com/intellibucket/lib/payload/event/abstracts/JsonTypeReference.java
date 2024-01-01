package com.intellibucket.lib.payload.event.abstracts;

import com.intellibucket.lib.payload.event.EventType;

public interface JsonTypeReference {
    default EventType getEventType() {
        return EventType.NONE;
    }

    void setEventType(EventType eventType);
}
