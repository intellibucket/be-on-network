package az.rock.flyjob.auth.dataAccess.model.entity.user.settings;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.common.FollowAccess;
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
@Table(name = "action_settings", schema = "auth")
@Entity(name = "ActionSettingsEntity")
public class ActionSettingsEntity extends BaseEntity {
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


    public static class Prototype {

        public static ActionSettingsEntity defaultSettings(UserEntity user) {
            return Builder.builder()
                    .version(1L)
                    .processStatus(ProcessStatus.COMPLETED)
                    .rowStatus(RowStatus.ACTIVE)
                    .user(user)
                    .shareUpdatesWhenIDoSomething(true)
                    .notifyMeWhenSomebodySpeaksAboutMe(true)
                    .isActiveTagAndMentionForMe(true)
                    .whoCanFollowMe(FollowAccess.EVERYONE)
                    .build();
        }

    }


    private ActionSettingsEntity(Builder builder) {
        setUser(builder.user);
        setShareUpdatesWhenIDoSomething(builder.shareUpdatesWhenIDoSomething);
        setNotifyMeWhenSomebodySpeaksAboutMe(builder.notifyMeWhenSomebodySpeaksAboutMe);
        setIsActiveTagAndMentionForMe(builder.isActiveTagAndMentionForMe);
        setWhoCanFollowMe(builder.whoCanFollowMe);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private Boolean shareUpdatesWhenIDoSomething;
        private Boolean notifyMeWhenSomebodySpeaksAboutMe;
        private Boolean isActiveTagAndMentionForMe;
        private FollowAccess whoCanFollowMe;
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

        public Builder shareUpdatesWhenIDoSomething(Boolean shareUpdatesWhenIDoSomething) {
            this.shareUpdatesWhenIDoSomething = shareUpdatesWhenIDoSomething;
            return this;
        }

        public Builder notifyMeWhenSomebodySpeaksAboutMe(Boolean notifyMeWhenSomebodySpeaksAboutMe) {
            this.notifyMeWhenSomebodySpeaksAboutMe = notifyMeWhenSomebodySpeaksAboutMe;
            return this;
        }

        public Builder isActiveTagAndMentionForMe(Boolean isActiveTagAndMentionForMe) {
            this.isActiveTagAndMentionForMe = isActiveTagAndMentionForMe;
            return this;
        }

        public Builder whoCanFollowMe(FollowAccess whoCanFollowMe) {
            this.whoCanFollowMe = whoCanFollowMe;
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

        public ActionSettingsEntity build() {
            return new ActionSettingsEntity(this);
        }
    }
}
