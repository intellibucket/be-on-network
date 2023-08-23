package az.rock.flyjob.js.messaging.listeners.abstracts;

import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import com.fasterxml.jackson.databind.JsonNode;

public interface AbstractUserCreatedMessageListener {
    void listenJobSeekerCreatedEvent(JsonNode node);
}
