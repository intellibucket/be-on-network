package com.intellibucket.flyjob.ws.auth.ports.input.listener.concretes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.flyjob.ws.auth.ports.input.listener.abstracts.AbstractProfilePictureListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProfilePictureKafkaListener implements AbstractProfilePictureListener {

    private final ObjectMapper objectMapper;

    public ProfilePictureKafkaListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "auth.profilePicture.created",groupId = "image-processor-service")
    public void listen(JsonNode record) {
//        var payload = this.convertToSagaRoot(record);
    }


//    private SagaRoot<ProfilePictureCreatedPayload> convertToSagaRoot(JsonNode record) {
//        var model = objectMapper.convertValue(record, SagaRoot.class);
//        var payloadObject = model.getData();
//        var payload = this.objectMapper.convertValue(payloadObject, ProfilePictureCreatedPayload.class);
//        return SagaRoot.replace(model, payload);
//    }
}
