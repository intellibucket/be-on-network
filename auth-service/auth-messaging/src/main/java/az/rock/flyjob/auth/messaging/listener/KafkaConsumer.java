package az.rock.flyjob.auth.messaging.listener;

import com.fasterxml.jackson.databind.JsonNode;

public interface KafkaConsumer <S>{
    <P extends S> P consume(JsonNode record);

    void listen(JsonNode record);
}
