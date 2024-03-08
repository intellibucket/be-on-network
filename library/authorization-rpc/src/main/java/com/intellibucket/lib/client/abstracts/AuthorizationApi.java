package com.intellibucket.lib.client.abstracts;

import java.util.UUID;

public interface AuthorizationApi {
    boolean authorize(String token);

    String fetchRelationLevel(UUID sourceUserId, UUID targetUserId);
}
