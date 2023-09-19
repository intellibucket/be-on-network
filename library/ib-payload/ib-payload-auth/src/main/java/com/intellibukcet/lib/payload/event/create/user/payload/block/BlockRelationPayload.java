package com.intellibukcet.lib.payload.event.create.user.payload.block;

import az.rock.lib.valueObject.UserType;
import com.intellibukcet.lib.payload.payload.Payload;

import java.util.UUID;

public class BlockRelationPayload extends Payload {

    private UserType userType;

    private UUID userId;

    private UserType targetUserType;

    private UUID targetUserId;

    public BlockRelationPayload(){};

    public BlockRelationPayload(UserType userType, UUID userId, UserType targetUserType, UUID targetUserId, String description) {
        this.userType = userType;
        this.userId = userId;
        this.targetUserType = targetUserType;
        this.targetUserId = targetUserId;
    }

    private BlockRelationPayload(Builder builder) {
        userType = builder.userType;
        userId = builder.userId;
        targetUserType = builder.targetUserType;
        targetUserId = builder.targetUserId;
    }


    public static final class Builder {
        private UserType userType;
        private UUID userId;
        private UserType targetUserType;
        private UUID targetUserId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userType(UserType val) {
            userType = val;
            return this;
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder targetUserType(UserType val) {
            targetUserType = val;
            return this;
        }

        public Builder targetUserId(UUID val) {
            targetUserId = val;
            return this;
        }


        public BlockRelationPayload build() {
            return new BlockRelationPayload(this);
        }
    }
}
