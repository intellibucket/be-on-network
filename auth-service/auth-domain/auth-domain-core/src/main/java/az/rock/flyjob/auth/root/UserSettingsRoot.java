package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.UserSettingsID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;

public class UserSettingsRoot extends AggregateRoot<UserSettingsID> {
    private final UserRoot user;

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

    public UserSettingsRoot(UserSettingsID userSettingsID,
                            Long version,
                            ProcessStatus processStatus,
                            DataStatus dataStatus,
                            ZonedDateTime createdDate,
                            ZonedDateTime modificationDate,
                            UserRoot user,
                            Language language,
                            Boolean isActiveDarkMode,
                            Boolean isActiveEmailNotification,
                            Boolean isActiveSmsNotification,
                            Boolean isActivePushNotification,
                            Boolean isActiveTwoFactorAuthentication,
                            Boolean isVisibleLocation,
                            Boolean isVisibleOnlineStatus,
                            Boolean isVisibleLastSeen,
                            Boolean isVisibleProfilePicture,
                            Boolean isVisibleEmail,
                            Boolean isVisibleResume) {
        super(userSettingsID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.user = user;
        this.language = language;
        this.isActiveDarkMode = isActiveDarkMode;
        this.isActiveEmailNotification = isActiveEmailNotification;
        this.isActiveSmsNotification = isActiveSmsNotification;
        this.isActivePushNotification = isActivePushNotification;
        this.isActiveTwoFactorAuthentication = isActiveTwoFactorAuthentication;
        this.isVisibleLocation = isVisibleLocation;
        this.isVisibleOnlineStatus = isVisibleOnlineStatus;
        this.isVisibleLastSeen = isVisibleLastSeen;
        this.isVisibleProfilePicture = isVisibleProfilePicture;
        this.isVisibleEmail = isVisibleEmail;
        this.isVisibleResume = isVisibleResume;
    }


    public UserRoot getUser() {
        return user;
    }

    public Language getLanguage() {
        return language;
    }

    public Boolean getActiveDarkMode() {
        return isActiveDarkMode;
    }

    public Boolean getActiveEmailNotification() {
        return isActiveEmailNotification;
    }

    public Boolean getActiveSmsNotification() {
        return isActiveSmsNotification;
    }

    public Boolean getActivePushNotification() {
        return isActivePushNotification;
    }

    public Boolean getActiveTwoFactorAuthentication() {
        return isActiveTwoFactorAuthentication;
    }

    public Boolean getVisibleLocation() {
        return isVisibleLocation;
    }

    public Boolean getVisibleOnlineStatus() {
        return isVisibleOnlineStatus;
    }

    public Boolean getVisibleLastSeen() {
        return isVisibleLastSeen;
    }

    public Boolean getVisibleProfilePicture() {
        return isVisibleProfilePicture;
    }

    public Boolean getVisibleEmail() {
        return isVisibleEmail;
    }

    public Boolean getVisibleResume() {
        return isVisibleResume;
    }

    public static final class Builder {
        private UserRoot user;
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
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserSettingsID userSettingsID;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserRoot user) {
            this.user = user;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder isActiveDarkMode(Boolean isActiveDarkMode) {
            this.isActiveDarkMode = isActiveDarkMode;
            return this;
        }

        public Builder isActiveEmailNotification(Boolean isActiveEmailNotification) {
            this.isActiveEmailNotification = isActiveEmailNotification;
            return this;
        }

        public Builder isActiveSmsNotification(Boolean isActiveSmsNotification) {
            this.isActiveSmsNotification = isActiveSmsNotification;
            return this;
        }

        public Builder isActivePushNotification(Boolean isActivePushNotification) {
            this.isActivePushNotification = isActivePushNotification;
            return this;
        }

        public Builder isActiveTwoFactorAuthentication(Boolean isActiveTwoFactorAuthentication) {
            this.isActiveTwoFactorAuthentication = isActiveTwoFactorAuthentication;
            return this;
        }

        public Builder isVisibleLocation(Boolean isVisibleLocation) {
            this.isVisibleLocation = isVisibleLocation;
            return this;
        }

        public Builder isVisibleOnlineStatus(Boolean isVisibleOnlineStatus) {
            this.isVisibleOnlineStatus = isVisibleOnlineStatus;
            return this;
        }

        public Builder isVisibleLastSeen(Boolean isVisibleLastSeen) {
            this.isVisibleLastSeen = isVisibleLastSeen;
            return this;
        }

        public Builder isVisibleProfilePicture(Boolean isVisibleProfilePicture) {
            this.isVisibleProfilePicture = isVisibleProfilePicture;
            return this;
        }

        public Builder isVisibleEmail(Boolean isVisibleEmail) {
            this.isVisibleEmail = isVisibleEmail;
            return this;
        }

        public Builder isVisibleResume(Boolean isVisibleResume) {
            this.isVisibleResume = isVisibleResume;
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

        public Builder dataStatus(DataStatus dataStatus) {
            this.dataStatus = dataStatus;
            return this;
        }

        public Builder createdDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modificationDate(ZonedDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder uuid(UserSettingsID userSettingsID) {
            this.userSettingsID = userSettingsID;
            return this;
        }

        public UserSettingsRoot build() {
            return new UserSettingsRoot(null, version, processStatus, dataStatus, createdDate, modificationDate, user, language, isActiveDarkMode, isActiveEmailNotification, isActiveSmsNotification, isActivePushNotification, isActiveTwoFactorAuthentication, isVisibleLocation, isVisibleOnlineStatus, isVisibleLastSeen, isVisibleProfilePicture, isVisibleEmail, isVisibleResume);
        }
    }
}