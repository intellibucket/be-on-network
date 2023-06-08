package az.rock.flyjob.auth.root.network;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.FollowID;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class FollowRelationRoot extends AggregateRoot<FollowID> {
    private final UserType followingUserType;

    private final UUID followingUserId;

    private final UserType followerUserType;

    private final UUID followerUserId;

    private FollowStatus followStatus;

    private final BlockReasonStatus blockReasonStatus;



    private FollowRelationRoot(Builder builder) {
        followingUserType = builder.followingUserType;
        followingUserId = builder.followingUserId;
        followerUserType = builder.followerUserType;
        followerUserId = builder.followerUserId;
        followStatus = builder.followStatus;
        blockReasonStatus = builder.blockReasonStatus;
    }


    public Boolean isAcceptedStatus() {
        return followStatus == FollowStatus.ACCEPTED;
    }

    public Boolean isBlockedStatus() {
        return followStatus == FollowStatus.BLOCKED;
    }

    public Boolean isPendingStatus() {
        return followStatus == FollowStatus.PENDING;
    }

    public Boolean isRejectedStatus() {
        return followStatus == FollowStatus.REJECTED;
    }

    public void reject() {
        followStatus = FollowStatus.REJECTED;
    }

    public void accept() {
        followStatus = FollowStatus.ACCEPTED;
    }

    public void block() {
        followStatus = FollowStatus.BLOCKED;
    }

    public void unblock() {
        followStatus = FollowStatus.ACCEPTED;
    }


    public static final class Builder {
        private FollowID followID;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
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

        public Builder followID(FollowID val) {
            followID = val;
            return this;
        }

        public Builder version(Long val) {
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

        public FollowRelationRoot build() {
            return new FollowRelationRoot(this);
        }
    }
}
