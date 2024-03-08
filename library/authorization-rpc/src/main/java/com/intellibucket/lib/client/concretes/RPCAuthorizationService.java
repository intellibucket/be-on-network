package com.intellibucket.lib.client.concretes;

import com.intellibucket.lib.client.abstracts.AuthorizationApi;
import com.intellibucket.lib.client.model.request.UserRelationLevelRequest;
import com.intellibucket.lib.client.model.request.UserRelationLevelServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.util.UUID;

public class RPCAuthorizationService implements AuthorizationApi {
    @GrpcClient("authorization-rpc")
    UserRelationLevelServiceGrpc.UserRelationLevelServiceStub userRelationLevelServiceStub;

    @Override
    public boolean authorize(String token) {
        return false;
    }

    @Override
    public String fetchRelationLevel(UUID sourceUserId, UUID targetUserId) {
        var request = UserRelationLevelRequest.newBuilder()
                .setSourceUserId(sourceUserId.toString())
                .setTargetUserId(targetUserId.toString())
                .build();
        return null;
    }
}
