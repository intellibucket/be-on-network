package com.intellibucket.lib.payload.event.create.user.payload.follow;

import az.rock.lib.valueObject.BlockReasonStatus;
import az.rock.lib.valueObject.FollowStatus;
import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class FollowRelationPayload extends Payload {
    private  UserType followingUserType;

    private  UUID followingUserId;

    private  UserType followerUserType;

    private  UUID followerUserId;

    private FollowStatus followStatus;

    private  BlockReasonStatus blockReasonStatus;

    public FollowRelationPayload(UserType followingUserType, UUID followingUserId, UserType followerUserType, UUID followerUserId, FollowStatus followStatus, BlockReasonStatus blockReasonStatus) {
        this.followingUserType = followingUserType;
        this.followingUserId = followingUserId;
        this.followerUserType = followerUserType;
        this.followerUserId = followerUserId;
        this.followStatus = followStatus;
        this.blockReasonStatus = blockReasonStatus;
    }

    public FollowRelationPayload(){}

    private FollowRelationPayload(Builder builder) {
        setFollowingUserType(builder.followingUserType);
        setFollowingUserId(builder.followingUserId);
        setFollowerUserType(builder.followerUserType);
        setFollowerUserId(builder.followerUserId);
        setFollowStatus(builder.followStatus);
        setBlockReasonStatus(builder.blockReasonStatus);
    }

    public UserType getFollowingUserType() {
        return followingUserType;
    }

    public void setFollowingUserType(UserType followingUserType) {
        this.followingUserType = followingUserType;
    }

    public UUID getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(UUID followingUserId) {
        this.followingUserId = followingUserId;
    }

    public UserType getFollowerUserType() {
        return followerUserType;
    }

    public void setFollowerUserType(UserType followerUserType) {
        this.followerUserType = followerUserType;
    }

    public UUID getFollowerUserId() {
        return followerUserId;
    }

    public void setFollowerUserId(UUID followerUserId) {
        this.followerUserId = followerUserId;
    }

    public FollowStatus getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(FollowStatus followStatus) {
        this.followStatus = followStatus;
    }

    public BlockReasonStatus getBlockReasonStatus() {
        return blockReasonStatus;
    }

    public void setBlockReasonStatus(BlockReasonStatus blockReasonStatus) {
        this.blockReasonStatus = blockReasonStatus;
    }


    public static final class Builder {
        private UserType followingUserType;
        private UUID followingUserId;
        private UserType followerUserType;
        private UUID followerUserId;
        private FollowStatus followStatus;
        private BlockReasonStatus blockReasonStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder followingUserType(UserType val) {
            followingUserType = val;
            return this;
        }

        public Builder followingUserId(UUID val) {
            followingUserId = val;
            return this;
        }

        public Builder followerUserType(UserType val) {
            followerUserType = val;
            return this;
        }

        public Builder followerUserId(UUID val) {
            followerUserId = val;
            return this;
        }

        public Builder followStatus(FollowStatus val) {
            followStatus = val;
            return this;
        }

        public Builder blockReasonStatus(BlockReasonStatus val) {
            blockReasonStatus = val;
            return this;
        }

        public FollowRelationPayload build() {
            return new FollowRelationPayload(this);
        }
    }
}
