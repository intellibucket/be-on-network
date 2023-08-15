package az.rock.flyjob.auth.messaging.listener;

import com.fasterxml.jackson.databind.JsonNode;

public interface KafkaConsumer <S>{

    void listen(JsonNode record);
}
