package az.rock.lib.event.impl;

public interface JsonTypeReference {
    default String getEventType(){
        return "NONE";
    }
}
