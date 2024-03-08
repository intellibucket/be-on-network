package com.intellibucket.lib.client.concretes;

import com.intellibucket.lib.client.abstracts.AuthorizationApi;

import java.util.UUID;

public class MockAuthorizationService implements AuthorizationApi {
    @Override
    public boolean authorize(String token) {
        return true;
    }

    @Override
    public String fetchRelationLevel(UUID sourceUserId, UUID targetUserId) {
        return null;
    }
}
