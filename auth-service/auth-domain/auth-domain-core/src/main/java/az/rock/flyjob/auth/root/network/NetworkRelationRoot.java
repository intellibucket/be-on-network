package az.rock.flyjob.auth.root.network;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.NetworkID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class NetworkRelationRoot extends AggregateRoot<NetworkID> {
    private final UUID requestOwnerId;

    private final UUID requestTargetId;

    private NetworkStatus networkStatus;

    private final BlockReasonStatus blockReasonStatus;

    public UUID getRequestTargetId() {
        return requestTargetId;
    }

    public UUID getOtherPair(UUID currentUserID) {
        return requestOwnerId.equals(currentUserID) ? requestTargetId : requestOwnerId;
    }

    public Boolean hasValidRelation(){
        return this.isAcceptedStatus() && this.isNonBlockedStatus();
    }

    public Boolean isAvailableForAccept() {
        return networkStatus == NetworkStatus.PENDING;
    }

    public Boolean isAvailableForReject() {
        return networkStatus == NetworkStatus.PENDING;
    }

    public Boolean isAvailableForBlock() {
        return networkStatus != NetworkStatus.BLOCKED;
    }

    public Boolean isAvailableForUnblock() {
        return networkStatus == NetworkStatus.BLOCKED;
    }
    public Boolean isAvailableForCancel() {
        return networkStatus == NetworkStatus.CANCELLED;
    }

    public Boolean hasNetwork(){
        return this.isAcceptedStatus() && this.isNonBlockedStatus();
    }


    public Boolean isMeRequestOwner(UUID currentUserID) {
        return requestOwnerId.equals(currentUserID);
    }

    public UUID getRequestOwnerId() {
        return requestOwnerId;
    }

    public NetworkStatus getNetworkStatus() {
        return networkStatus;
    }

    public BlockReasonStatus getBlockReasonStatus() {
        return blockReasonStatus;
    }

    private NetworkRelationRoot(Builder builder) {
        super(builder.networkID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        requestOwnerId = builder.requestOwnerId;
        requestTargetId = builder.requestTargetId;
        networkStatus = builder.networkStatus;
        blockReasonStatus = builder.blockReasonStatus;
    }

    public Boolean isAcceptedStatus() {
        return networkStatus == NetworkStatus.ACCEPTED;
    }

    public Boolean isBlockedStatus() {
        return networkStatus == NetworkStatus.BLOCKED;
    }

    public Boolean isNonBlockedStatus() {
        return networkStatus != NetworkStatus.BLOCKED;
    }


    public Boolean isPendingStatus() {
        return networkStatus == NetworkStatus.PENDING;
    }

    public Boolean isRejectedStatus() {
        return networkStatus == NetworkStatus.REJECTED;
    }

    public void reject() {
        networkStatus = NetworkStatus.REJECTED;
    }

    public void accept() {
        networkStatus = NetworkStatus.ACCEPTED;
    }
    public void cancel() {
        networkStatus = NetworkStatus.CANCELLED;
    }

    public void block() {
        networkStatus = NetworkStatus.BLOCKED;
    }


    public static final class Builder {

        private NetworkID networkID;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;

        private UUID requestOwnerId;
        private UUID requestTargetId;
        private NetworkStatus networkStatus;
        private BlockReasonStatus blockReasonStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder networkID(NetworkID val) {
            networkID = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
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

        public NetworkRelationRoot build() {
            return new NetworkRelationRoot(this);
        }
    }
}
