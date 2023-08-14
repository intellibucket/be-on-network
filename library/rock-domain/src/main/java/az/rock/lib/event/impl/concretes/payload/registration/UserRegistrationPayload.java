package az.rock.lib.event.impl.concretes.payload.registration;

import az.rock.lib.event.impl.concretes.payload.Payload;

import java.time.ZonedDateTime;
import java.util.List;


public abstract class UserRegistrationPayload implements Payload {
    private Boolean success;
    private ZonedDateTime time;
    private List<String> messages;

    public UserRegistrationPayload(Boolean success, ZonedDateTime time, List<String> messages) {
        this.success = success;
        this.time = time;
        this.messages = messages;
    }

    public UserRegistrationPayload() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
