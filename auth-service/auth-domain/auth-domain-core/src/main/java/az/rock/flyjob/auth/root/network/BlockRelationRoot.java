package az.rock.flyjob.auth.root.network;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.BlockID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.UserType;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BlockRelationRoot extends AggregateRoot<BlockID> {
    private UserType userType;

    private UUID userId;

    private UserType targetUserType;

    private UUID targetUserId;

    private String description;

    private BlockRelationRoot(Builder builder) {
        super(builder.blockID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userType = builder.userType;
        userId = builder.userId;
        targetUserType = builder.targetUserType;
        targetUserId = builder.targetUserId;
        description = builder.description;
    }

    public UserType getUserType() {
        return userType;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserType getTargetUserType() {
        return targetUserType;
    }

    public UUID getTargetUserId() {
        return targetUserId;
    }

    public String getDescription() {
        return description;
    }

    public static final class Builder {
        private BlockID blockID;

        private Version version;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private ZonedDateTime createdDate;

        private ZonedDateTime modificationDate;

        private UserType userType;
        private UUID userId;
        private UserType targetUserType;
        private UUID targetUserId;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(UUID uuid){
            this.blockID = BlockID.of(uuid);
            return this;
        }

        public Builder uuid(BlockID blockID){
            this.blockID = blockID;
            return this;
        }

        public Builder version(Long val) {
            version = Version.of(val);
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

        public Builder description(String val) {
            description = val;
            return this;
        }

        public BlockRelationRoot build() {
            return new BlockRelationRoot(this);
        }
    }
}
