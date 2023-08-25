package com.intellibukcet.lib.payload.event.abstracts;

public interface JsonTypeReference {
    default String getEventType(){
        return "NONE";
    }
}
