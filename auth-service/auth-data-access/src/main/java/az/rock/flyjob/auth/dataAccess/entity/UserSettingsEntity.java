package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.ProcessStatus;
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
@Table(name = "user_settings", schema = "auth")
@Entity(name = "UserSettingsEntity")
public class UserSettingsEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "is_active_dark_mode")
    private Boolean isActiveDarkMode;

    @Column(name = "is_active_email_notification")
    private Boolean isActiveEmailNotification;

    @Column(name = "is_active_sms_notification")
    private Boolean isActiveSmsNotification;

    @Column(name = "is_active_push_notification")
    private Boolean isActivePushNotification;

    @Column(name = "is_active_two_factor_authentication")
    private Boolean isActiveTwoFactorAuthentication;

    @Column(name = "is_visible_location", nullable = false)
    private Boolean isVisibleLocation;

    @Column(name = "is_visible_online_status", nullable = false)
    private Boolean isVisibleOnlineStatus;

    @Column(name = "is_visible_last_seen", nullable = false)
    private Boolean isVisibleLastSeen;

    @Column(name = "is_visible_profile_picture", nullable = false)
    private Boolean isVisibleProfilePicture;

    @Column(name = "is_visible_email", nullable = false)
    private Boolean isVisibleEmail;

    @Column(name = "is_visible_resume", nullable = false)
    private Boolean isVisibleResume;

    private UserSettingsEntity(Builder builder) {
        setUser(builder.user);
        setLanguage(builder.language);
        setIsActiveDarkMode(builder.isActiveDarkMode);
        setIsActiveEmailNotification(builder.isActiveEmailNotification);
        setIsActiveSmsNotification(builder.isActiveSmsNotification);
        setIsActivePushNotification(builder.isActivePushNotification);
        setIsActiveTwoFactorAuthentication(builder.isActiveTwoFactorAuthentication);
        setIsVisibleLocation(builder.isVisibleLocation);
        setIsVisibleOnlineStatus(builder.isVisibleOnlineStatus);
        setIsVisibleLastSeen(builder.isVisibleLastSeen);
        setIsVisibleProfilePicture(builder.isVisibleProfilePicture);
        setIsVisibleEmail(builder.isVisibleEmail);
        setIsVisibleResume(builder.isVisibleResume);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setDataStatus(builder.dataStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private Language language;
        private Boolean isActiveDarkMode;
        private Boolean isActiveEmailNotification;
        private Boolean isActiveSmsNotification;
        private Boolean isActivePushNotification;
        private Boolean isActiveTwoFactorAuthentication;
        private Boolean isVisibleLocation;
        private Boolean isVisibleOnlineStatus;
        private Boolean isVisibleLastSeen;
        private Boolean isVisibleProfilePicture;
        private Boolean isVisibleEmail;
        private Boolean isVisibleResume;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder language(Language val) {
            language = val;
            return this;
        }

        public Builder isActiveDarkMode(Boolean val) {
            isActiveDarkMode = val;
            return this;
        }

        public Builder isActiveEmailNotification(Boolean val) {
            isActiveEmailNotification = val;
            return this;
        }

        public Builder isActiveSmsNotification(Boolean val) {
            isActiveSmsNotification = val;
            return this;
        }

        public Builder isActivePushNotification(Boolean val) {
            isActivePushNotification = val;
            return this;
        }

        public Builder isActiveTwoFactorAuthentication(Boolean val) {
            isActiveTwoFactorAuthentication = val;
            return this;
        }

        public Builder isVisibleLocation(Boolean val) {
            isVisibleLocation = val;
            return this;
        }

        public Builder isVisibleOnlineStatus(Boolean val) {
            isVisibleOnlineStatus = val;
            return this;
        }

        public Builder isVisibleLastSeen(Boolean val) {
            isVisibleLastSeen = val;
            return this;
        }

        public Builder isVisibleProfilePicture(Boolean val) {
            isVisibleProfilePicture = val;
            return this;
        }

        public Builder isVisibleEmail(Boolean val) {
            isVisibleEmail = val;
            return this;
        }

        public Builder isVisibleResume(Boolean val) {
            isVisibleResume = val;
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

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
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

        public UserSettingsEntity build() {
            return new UserSettingsEntity(this);
        }
    }
}
