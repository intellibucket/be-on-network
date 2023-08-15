package az.rock.lib.event.impl.abstracts;

public interface JsonTypeReference {
    default String getEventType(){
        return "NONE";
    }
}
