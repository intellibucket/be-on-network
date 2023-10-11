package az.rock.flyjob.auth.dataAccess.model.entity.user.settings;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification_settings", schema = "auth")
@Entity(name = "NotificationSettings")
public class NotificationSettings extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private Boolean notifyMeWhenSomebodySpeaksAboutMe;

    private Boolean notifyMeWhenSomebodySpeaksAboutMyPosts;

    private Boolean notifyMeWhenSomebodySpeaksAboutMyComments;

    private Boolean notifyMeWhenSomebodySpeaksAboutMyReplies;
}
