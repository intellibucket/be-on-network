package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsDataAccessMapper implements AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> {


    @Override
    public UserSettingsRoot toRoot(UserSettingsEntity entity) {
        return UserSettingsRoot.Builder
                .builder()
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
                .build();
    }

    @Override
    public UserSettingsEntity toEntity(UserSettingsRoot root) {
        return UserSettingsEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
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
                .build();
    }

    @Override
    public UserSettingsEntity toNewEntity(UserSettingsRoot root) {
        return UserSettingsEntity.Builder
                .builder()
                .uuid(root.getUserID().getId())
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
                .build();
    }
}
