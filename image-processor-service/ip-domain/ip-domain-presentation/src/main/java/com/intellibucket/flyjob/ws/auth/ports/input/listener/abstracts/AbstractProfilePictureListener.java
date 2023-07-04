package com.intellibucket.flyjob.ws.auth.ports.input.listener.abstracts;

import com.fasterxml.jackson.databind.JsonNode;

public interface AbstractProfilePictureListener {
    void listen(JsonNode record);
}
