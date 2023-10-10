package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.auth.UserSettingsID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class UserSettingsRoot extends AggregateRoot<UserSettingsID> {
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

    private UserSettingsRoot(Builder builder) {
        super(builder.uuid, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
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

    public UserSettingsRoot changeLanguage(Language language) {
        this.language = language;
        return this;
    }

    public UserSettingsRoot changeDarkMode(Boolean isActiveDarkMode) {
        this.isActiveDarkMode = isActiveDarkMode;
        return this;
    }

    public UserSettingsRoot changeEmailNotification(Boolean isActiveEmailNotification) {
        this.isActiveEmailNotification = isActiveEmailNotification;
        return this;
    }

    public UserSettingsRoot changeSmsNotification(Boolean isActiveSmsNotification) {
        this.isActiveSmsNotification = isActiveSmsNotification;
        return this;
    }

    public UserSettingsRoot changePushNotification(Boolean isActivePushNotification) {
        this.isActivePushNotification = isActivePushNotification;
        return this;
    }

    public UserSettingsRoot changeTwoFactorAuthentication(Boolean isActiveTwoFactorAuthentication) {
        this.isActiveTwoFactorAuthentication = isActiveTwoFactorAuthentication;
        return this;
    }

    public UserSettingsRoot changeLocationVisibility(Boolean isVisibleLocation) {
        this.isVisibleLocation = isVisibleLocation;
        return this;
    }

    public UserSettingsRoot changeOnlineStatusVisibility(Boolean isVisibleOnlineStatus) {
        this.isVisibleOnlineStatus = isVisibleOnlineStatus;
        return this;
    }

    public UserSettingsRoot changeLastSeenVisibility(Boolean isVisibleLastSeen) {
        this.isVisibleLastSeen = isVisibleLastSeen;
        return this;
    }

    public UserSettingsRoot changeProfilePictureVisibility(Boolean isVisibleProfilePicture) {
        this.isVisibleProfilePicture = isVisibleProfilePicture;
        return this;
    }

    public UserSettingsRoot changeEmailVisibility(Boolean isVisibleEmail) {
        this.isVisibleEmail = isVisibleEmail;
        return this;
    }

    public UserSettingsRoot changeResumeVisibility(Boolean isVisibleResume) {
        this.isVisibleResume = isVisibleResume;
        return this;
    }


    public static class Builder {
        public UserSettingsID uuid;
        public Version version;
        public ProcessStatus processStatus;
        public RowStatus rowStatus;
        public ZonedDateTime createdDate;
        public ZonedDateTime lastModifiedDate;
        private UserID userID;
        private Language language = Language.EN;
        private Boolean isActiveDarkMode = false;

        private Boolean isActiveEmailNotification = false;

        private Boolean isActiveSmsNotification = false;

        private Boolean isActivePushNotification = true;

        private Boolean isActiveTwoFactorAuthentication = false;

        private Boolean isVisibleLocation = true;

        private Boolean isVisibleOnlineStatus = true;
        private Boolean isVisibleLastSeen = true;
        private Boolean isVisibleProfilePicture = true;
        private Boolean isVisibleEmail = true;
        private Boolean isVisibleResume = true;

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