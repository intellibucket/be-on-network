package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.auth.UserSettingsID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSettingsDataAccessMapper implements AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> {


    @Override
    public Optional<UserSettingsRoot> toRoot(UserSettingsEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of
                (UserSettingsRoot.Builder
                        .builder()
                        .userSettingsID(UserSettingsID.of(entity.getUuid()))
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .lastModifiedDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .version(entity.getVersion())
                        .processStatus(entity.getProcessStatus())
                        .rowStatus(entity.getRowStatus())
                        .userID(UserID.of(entity.getUser().getUuid()))
                        .language(entity.getLanguage())
                        .isActiveDarkMode(entity.getIsActiveDarkMode())
                        .isActiveEmailNotification(entity.getIsActiveEmailNotification())
                        .isActiveSmsNotification(entity.getIsActiveSmsNotification())
                        .isActivePushNotification(entity.getIsActivePushNotification())
                        .isActiveTwoFactorAuthentication(entity.getIsActiveTwoFactorAuthentication())
                        .isVisibleLocation(entity.getIsVisibleLocation())
                        .isVisibleOnlineStatus(entity.getIsVisibleOnlineStatus())
                        .isVisibleLastSeen(entity.getIsVisibleLastSeen())
                        .isVisibleProfilePicture(entity.getIsVisibleProfilePicture())
                        .isVisibleEmail(entity.getIsVisibleEmail())
                        .isVisibleResume(entity.getIsVisibleResume())
                        .build()
        );
    }

    @Override
    public Optional<UserSettingsEntity> toEntity(UserSettingsRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(UserSettingsEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .user(UserEntity.referenceObject(root.getUserID().getAbsoluteID()))
                .language(root.getLanguage())
                .isActiveDarkMode(root.isActiveDarkMode())
                .isActiveEmailNotification(root.isActiveEmailNotification())
                .isActiveSmsNotification(root.isActiveSmsNotification())
                .isActivePushNotification(root.isActivePushNotification())
                .isActiveTwoFactorAuthentication(root.isActiveTwoFactorAuthentication())
                .isVisibleLocation(root.isVisibleLocation())
                .isVisibleOnlineStatus(root.isVisibleOnlineStatus())
                .isVisibleLastSeen(root.isVisibleLastSeen())
                .isVisibleProfilePicture(root.isVisibleProfilePicture())
                .isVisibleEmail(root.isVisibleEmail())
                .isVisibleResume(root.isVisibleResume())
                .build());
    }

    @Override
    public Optional<UserSettingsEntity> toNewEntity(UserSettingsRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(UserSettingsEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .language(root.getLanguage())
                .isActiveDarkMode(root.isActiveDarkMode())
                .isActiveEmailNotification(root.isActiveEmailNotification())
                .isActiveSmsNotification(root.isActiveSmsNotification())
                .isActivePushNotification(root.isActivePushNotification())
                .isActiveTwoFactorAuthentication(root.isActiveTwoFactorAuthentication())
                .isVisibleLocation(root.isVisibleLocation())
                .isVisibleOnlineStatus(root.isVisibleOnlineStatus())
                .isVisibleLastSeen(root.isVisibleLastSeen())
                .isVisibleProfilePicture(root.isVisibleProfilePicture())
                .isVisibleEmail(root.isVisibleEmail())
                .isVisibleResume(root.isVisibleResume())
                .build());
    }

}
