package az.rock.flyjob.auth.dataAccess.model.entity.user.settings;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.common.FollowAccess;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "action_settings", schema = "auth")
@Entity(name = "ActionSettings")
public class ActionSettings extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(name = "share_updates_when_i_do_something", nullable = false)
    private Boolean shareUpdatesWhenIDoSomething;

    @Column(name = "notify_me_when_somebody_speaks_about_me", nullable = false)
    private Boolean notifyMeWhenSomebodySpeaksAboutMe;

    @Column(name = "notify_me_when_somebody_speaks_about_my_posts", nullable = false)
    private Boolean isActiveTagAndMentionForMe;

    @Column(name = "who_can_follow_me", nullable = false)
    private FollowAccess whoCanFollowMe;

}
