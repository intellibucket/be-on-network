package az.rock.flyjob.auth.dataAccess.model.entity.network;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "block_relation", schema = "network")
@Entity(name = "BlockRelationEntity")
public class BlockRelationEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false, updatable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    private UserType targetUserType;

    @Column(nullable = false, updatable = false)
    private UUID targetUserId;

    @Column(name = "description")
    private String description;

    private BlockRelationEntity(Builder builder) {
        setUserType(builder.userType);
        setUserId(builder.userId);
        setTargetUserType(builder.targetUserType);
        setTargetUserId(builder.targetUserId);
        setDescription(builder.description);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserType userType;
        private UUID userId;
        private UserType targetUserType;
        private UUID targetUserId;
        private String description;
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

        public BlockRelationEntity build() {
            return new BlockRelationEntity(this);
        }
    }
}