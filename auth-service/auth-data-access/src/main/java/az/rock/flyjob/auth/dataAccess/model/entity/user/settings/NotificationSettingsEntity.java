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
@Table(name = "notification_settings", schema = "auth")
@Entity(name = "NotificationSettingsEntity")
public class NotificationSettingsEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(name = "notify_me_when_somebody_speaks_about_me", nullable = false)
    private Boolean notifyMeWhenSomebodySpeaksAboutMe;

    @Column(name = "notify_me_when_somebody_speaks_about_me_on_posts", nullable = false)
    private Boolean notifyMeWhenSomebodySpeaksAboutMeOnPosts;

    @Column(name = "notify_me_when_somebody_speaks_about_me_on_comments", nullable = false)
    private Boolean notifyMeWhenSomebodySpeaksAboutMeOnComments;

    @Column(name = "notify_me_when_somebody_speaks_about_my_replies", nullable = false)
    private Boolean notifyMeWhenSomebodySpeaksAboutMyReplies;

    private NotificationSettingsEntity(Builder builder) {
        setUser(builder.user);
        setNotifyMeWhenSomebodySpeaksAboutMe(builder.notifyMeWhenSomebodySpeaksAboutMe);
        setNotifyMeWhenSomebodySpeaksAboutMeOnPosts(builder.notifyMeWhenSomebodySpeaksAboutMeOnPosts);
        setNotifyMeWhenSomebodySpeaksAboutMeOnComments(builder.notifyMeWhenSomebodySpeaksAboutMeOnComments);
        setNotifyMeWhenSomebodySpeaksAboutMyReplies(builder.notifyMeWhenSomebodySpeaksAboutMyReplies);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }

    public static class Prototype {

        public static NotificationSettingsEntity defaultSettings(UserEntity user) {
            return Builder.builder()
                    .version(1L)
                    .processStatus(ProcessStatus.COMPLETED)
                    .rowStatus(RowStatus.ACTIVE)
                    .user(user)
                    .notifyMeWhenSomebodySpeaksAboutMe(true)
                    .notifyMeWhenSomebodySpeaksAboutMeOnPosts(true)
                    .notifyMeWhenSomebodySpeaksAboutMeOnComments(true)
                    .notifyMeWhenSomebodySpeaksAboutMyReplies(true)
                    .build();
        }

    }


    public static final class Builder {
        private UserEntity user;
        private Boolean notifyMeWhenSomebodySpeaksAboutMe;
        private Boolean notifyMeWhenSomebodySpeaksAboutMeOnPosts;
        private Boolean notifyMeWhenSomebodySpeaksAboutMeOnComments;
        private Boolean notifyMeWhenSomebodySpeaksAboutMyReplies;
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

        public Builder notifyMeWhenSomebodySpeaksAboutMe(Boolean notifyMeWhenSomebodySpeaksAboutMe) {
            this.notifyMeWhenSomebodySpeaksAboutMe = notifyMeWhenSomebodySpeaksAboutMe;
            return this;
        }

        public Builder notifyMeWhenSomebodySpeaksAboutMeOnPosts(Boolean notifyMeWhenSomebodySpeaksAboutMeOnPosts) {
            this.notifyMeWhenSomebodySpeaksAboutMeOnPosts = notifyMeWhenSomebodySpeaksAboutMeOnPosts;
            return this;
        }

        public Builder notifyMeWhenSomebodySpeaksAboutMeOnComments(Boolean notifyMeWhenSomebodySpeaksAboutMeOnComments) {
            this.notifyMeWhenSomebodySpeaksAboutMeOnComments = notifyMeWhenSomebodySpeaksAboutMeOnComments;
            return this;
        }

        public Builder notifyMeWhenSomebodySpeaksAboutMyReplies(Boolean notifyMeWhenSomebodySpeaksAboutMyReplies) {
            this.notifyMeWhenSomebodySpeaksAboutMyReplies = notifyMeWhenSomebodySpeaksAboutMyReplies;
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

        public NotificationSettingsEntity build() {
            return new NotificationSettingsEntity(this);
        }
    }
}
