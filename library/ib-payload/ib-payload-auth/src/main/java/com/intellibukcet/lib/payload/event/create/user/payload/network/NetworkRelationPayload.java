package com.intellibukcet.lib.payload.event.create.user.payload.network;

import az.rock.lib.valueObject.BlockReasonStatus;
import az.rock.lib.valueObject.NetworkStatus;
import com.intellibukcet.lib.payload.payload.Payload;

import java.util.UUID;

public class NetworkRelationPayload extends Payload {
    private UUID requestOwnerId;

    private UUID requestTargetId;

    private NetworkStatus networkStatus;

    private BlockReasonStatus blockReasonStatus;

    public NetworkRelationPayload() {
    }

    public NetworkRelationPayload(UUID requestOwnerId, UUID requestTargetId, NetworkStatus networkStatus, BlockReasonStatus blockReasonStatus) {
        this.requestOwnerId = requestOwnerId;
        this.requestTargetId = requestTargetId;
        this.networkStatus = networkStatus;
        this.blockReasonStatus = blockReasonStatus;
    }

    public UUID getRequestOwnerId() {
        return requestOwnerId;
    }

    public void setRequestOwnerId(UUID requestOwnerId) {
        this.requestOwnerId = requestOwnerId;
    }

    public UUID getRequestTargetId() {
        return requestTargetId;
    }

    public void setRequestTargetId(UUID requestTargetId) {
        this.requestTargetId = requestTargetId;
    }

    public NetworkStatus getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(NetworkStatus networkStatus) {
        this.networkStatus = networkStatus;
    }

    public BlockReasonStatus getBlockReasonStatus() {
        return blockReasonStatus;
    }

    public void setBlockReasonStatus(BlockReasonStatus blockReasonStatus) {
        this.blockReasonStatus = blockReasonStatus;
    }

    private NetworkRelationPayload(Builder builder) {
        requestOwnerId = builder.requestOwnerId;
        requestTargetId = builder.requestTargetId;
        networkStatus = builder.networkStatus;
        blockReasonStatus = builder.blockReasonStatus;
    }

    public static final class Builder {
        private UUID requestOwnerId;
        private UUID requestTargetId;
        private NetworkStatus networkStatus;
        private BlockReasonStatus blockReasonStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder requestOwnerId(UUID val) {
            requestOwnerId = val;
            return this;
        }

        public Builder requestTargetId(UUID val) {
            requestTargetId = val;
            return this;
        }

        public Builder networkStatus(NetworkStatus val) {
            networkStatus = val;
            return this;
        }

        public Builder blockReasonStatus(BlockReasonStatus val) {
            blockReasonStatus = val;
            return this;
        }

        public NetworkRelationPayload build() {
            return new NetworkRelationPayload(this);
        }
    }
}
