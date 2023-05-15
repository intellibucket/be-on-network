package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.Language;
import jakarta.persistence.*;
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

}
