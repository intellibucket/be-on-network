package az.rock.flyjob.auth.dataAccess.model.entity.user.settings;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
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
@Table(name = "account_settings", schema = "auth")
@Entity(name = "AccountSettingsEntity")
public class AccountSettingsEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(name = "is_possible_to_find_me_by_email", nullable = false)
    private Boolean isPossibleToFindMeByEmail;

    @Column(name = "is_possible_to_find_me_by_phone_number", nullable = false)
    private Boolean isPossibleToFindMeByPhoneNumber;

    @Column(name = "is_possible_to_find_me_by_user_name", nullable = false)
    private Boolean isPossibleToFindMeByUserName;

    @Column(name = "is_possible_to_find_me_by_full_name", nullable = false)
    private Boolean isPossibleToFindMeByFullName;

    @Column(name = "is_possible_to_find_me_by_location", nullable = false)
    private Boolean isPossibleToFindMeByLocation;

    private AccountSettingsEntity(Builder builder) {
        setUser(builder.user);
        setIsPossibleToFindMeByEmail(builder.isPossibleToFindMeByEmail);
        setIsPossibleToFindMeByPhoneNumber(builder.isPossibleToFindMeByPhoneNumber);
        setIsPossibleToFindMeByUserName(builder.isPossibleToFindMeByUserName);
        setIsPossibleToFindMeByFullName(builder.isPossibleToFindMeByFullName);
        setIsPossibleToFindMeByLocation(builder.isPossibleToFindMeByLocation);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static class Prototype {

        public static AccountSettingsEntity defaultSettings(UserEntity user) {
            return AccountSettingsEntity.Builder
                    .builder()
                    .version(1L)
                    .processStatus(ProcessStatus.COMPLETED)
                    .rowStatus(RowStatus.ACTIVE)
                    .user(user)
                    .isPossibleToFindMeByEmail(true)
                    .isPossibleToFindMeByPhoneNumber(true)
                    .isPossibleToFindMeByUserName(true)
                    .isPossibleToFindMeByFullName(true)
                    .isPossibleToFindMeByLocation(true)
                    .build();
        }

    }


    public static final class Builder {
        private UserEntity user;
        private Boolean isPossibleToFindMeByEmail;
        private Boolean isPossibleToFindMeByPhoneNumber;
        private Boolean isPossibleToFindMeByUserName;
        private Boolean isPossibleToFindMeByFullName;
        private Boolean isPossibleToFindMeByLocation;
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

        public Builder user(UserEntity user) {
            this.user = user;
            return this;
        }

        public Builder isPossibleToFindMeByEmail(Boolean isPossibleToFindMeByEmail) {
            this.isPossibleToFindMeByEmail = isPossibleToFindMeByEmail;
            return this;
        }

        public Builder isPossibleToFindMeByPhoneNumber(Boolean isPossibleToFindMeByPhoneNumber) {
            this.isPossibleToFindMeByPhoneNumber = isPossibleToFindMeByPhoneNumber;
            return this;
        }

        public Builder isPossibleToFindMeByUserName(Boolean isPossibleToFindMeByUserName) {
            this.isPossibleToFindMeByUserName = isPossibleToFindMeByUserName;
            return this;
        }

        public Builder isPossibleToFindMeByFullName(Boolean isPossibleToFindMeByFullName) {
            this.isPossibleToFindMeByFullName = isPossibleToFindMeByFullName;
            return this;
        }

        public Builder isPossibleToFindMeByLocation(Boolean isPossibleToFindMeByLocation) {
            this.isPossibleToFindMeByLocation = isPossibleToFindMeByLocation;
            return this;
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public AccountSettingsEntity build() {
            return new AccountSettingsEntity(this);
        }
    }
}
