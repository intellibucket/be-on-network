package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.domain.id.UserSettingsID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

public class UserSettingsRoot extends AggregateRoot<UserSettingsID> {
    private final UserID userID;

    private final Language language;

    private final Boolean isActiveDarkMode;

    private final Boolean isActiveEmailNotification;

    private final Boolean isActiveSmsNotification;

    private final Boolean isActivePushNotification;

    private final Boolean isActiveTwoFactorAuthentication;

    private final Boolean isVisibleLocation;

    private final Boolean isVisibleOnlineStatus;

    private final Boolean isVisibleLastSeen;

    private final Boolean isVisibleProfilePicture;

    private final Boolean isVisibleEmail;

    private final Boolean isVisibleResume;

    private UserSettingsRoot(Builder builder) {
        super(builder.uuid, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.lastModifiedDate);
        userID = builder.userID;
        language = builder.language;
        isActiveDarkMode = builder.isActiveDarkMode;
        isActiveEmailNotification = builder.isActiveEmailNotification;
        isActiveSmsNotification = builder.isActiveSmsNotification;
        isActivePushNotification = builder.isActivePushNotification;
        isActiveTwoFactorAuthentication = builder.isActiveTwoFactorAuthentication;
        isVisibleLocation = builder.isVisibleLocation;
        isVisibleOnlineStatus = builder.isVisibleOnlineStatus;
        isVisibleLastSeen = builder.isVisibleLastSeen;
        isVisibleProfilePicture = builder.isVisibleProfilePicture;
        isVisibleEmail = builder.isVisibleEmail;
        isVisibleResume = builder.isVisibleResume;
    }

    public UserID getUserID() {
        return userID;
    }

    public Language getLanguage() {
        return language;
    }

    public Boolean isActiveDarkMode() {
        return isActiveDarkMode;
    }

    public Boolean isActiveEmailNotification() {
        return isActiveEmailNotification;
    }

    public Boolean isActiveSmsNotification() {
        return isActiveSmsNotification;
    }

    public Boolean isActivePushNotification() {
        return isActivePushNotification;
    }

    public Boolean isActiveTwoFactorAuthentication() {
        return isActiveTwoFactorAuthentication;
    }

    public Boolean isVisibleLocation() {
        return isVisibleLocation;
    }

    public Boolean isVisibleOnlineStatus() {
        return isVisibleOnlineStatus;
    }

    public Boolean isVisibleLastSeen() {
        return isVisibleLastSeen;
    }

    public Boolean isVisibleProfilePicture() {
        return isVisibleProfilePicture;
    }

    public Boolean isVisibleEmail() {
        return isVisibleEmail;
    }

    public Boolean isVisibleResume() {
        return isVisibleResume;
    }

    public static final class Builder {
        public UserSettingsID uuid;
        public Long version;
        public ProcessStatus processStatus;
        public DataStatus dataStatus;
        public ZonedDateTime createdDate;
        public ZonedDateTime lastModifiedDate;
        private UserID userID;
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

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userSettingsID(UserSettingsID val) {
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder userID(UserID val) {
            userID = val;
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

        public UserSettingsRoot build() {
            return new UserSettingsRoot(this);
        }
    }
}