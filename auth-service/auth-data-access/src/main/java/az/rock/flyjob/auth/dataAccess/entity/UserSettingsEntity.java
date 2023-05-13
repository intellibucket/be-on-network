package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_settings", schema = "auth")
@Entity(name = "UserSettingsEntity")
public class UserSettingsEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Language language;

    private Boolean isDarkMode;

    private Boolean isEmailNotification;

    private Boolean isSmsNotification;

    private Boolean isPushNotification;

    private Boolean isTwoFactorAuthentication;

    private Boolean visibleLocation;

    private Boolean visibleOnlineStatus;

    private Boolean visibleLastSeen;

    private Boolean visibleProfilePicture;

    private Boolean visibleEmail;

    private Boolean visibleResume;

}
