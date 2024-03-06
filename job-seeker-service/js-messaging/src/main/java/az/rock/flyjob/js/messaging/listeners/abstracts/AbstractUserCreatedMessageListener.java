package az.rock.flyjob.js.messaging.listeners.abstracts;

import com.fasterxml.jackson.databind.JsonNode;

public interface AbstractUserCreatedMessageListener {
    void listenJobSeekerCreatedEvent(JsonNode node);
}
