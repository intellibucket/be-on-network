package az.rock.flyjob.auth.dataAccess.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "follow_relation", schema = "network", indexes = {
        @Index(name = "ıdx_following_id", columnList = "followingUserId")
})
@Entity
public class FollowRelationEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserType followingUserType;

    @Column(nullable = false, updatable = false)
    private UUID followingUserId;

    @Enumerated(EnumType.STRING)
    private UserType followedUserType;

    @Column(nullable = false, updatable = false)
    private UUID followedUserId;

    @Enumerated(EnumType.STRING)
    private FollowStatus followStatus;

    @Enumerated(EnumType.STRING)
    private BlockReasonStatus blockReasonStatus;

    private FollowRelationEntity(Builder builder) {
        setFollowingUserType(builder.followingUserType);
        setFollowingUserId(builder.followingUserId);
        setFollowedUserType(builder.followedUserType);
        setFollowedUserId(builder.followedUserId);
        setFollowStatus(builder.followStatus);
        setBlockReasonStatus(builder.blockReasonStatus);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserType followingUserType;
        private UUID followingUserId;
        private UserType followedUserType;
        private UUID followedUserId;
        private FollowStatus followStatus;
        private BlockReasonStatus blockReasonStatus;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

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

        public Builder followedUserType(UserType val) {
            followedUserType = val;
            return this;
        }

        public Builder followedUserId(UUID val) {
            followedUserId = val;
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

        public Builder uuid(UUID val) {
            uuid = val;
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

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public FollowRelationEntity build() {
            return new FollowRelationEntity(this);
        }
    }
}
