package az.rock.lib.event.payload;

import java.util.List;
import java.util.Optional;


public class FailPayload extends Payload{
    private List<String> messages;

    public FailPayload(){}

    public FailPayload(List<String> messages){
        this.messages = messages;
    }

    public FailPayload(String message){
        this.messages = List.of(message);
    }

    public Boolean hasMessage(){
        return !this.messages.isEmpty();
    }

    public Optional<String> findFirst(){
        return this.messages.stream().findFirst();
    }

    public String findFirst(String defaultMessage){
        return this.messages.stream().findFirst().orElse(defaultMessage);
    }


    public List<String> getMessages() {
        if (this.messages == null) return List.of();
        return this.messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
