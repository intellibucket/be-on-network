package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.root.UserSettingsRoot;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsDataAccessMapper implements AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> {

    private final UserDataAccessMapper userDataAccessMapper;

    public UserSettingsDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public UserSettingsRoot toRoot(UserSettingsEntity entity) {
        return UserSettingsRoot.Builder
                .builder()
                .user(this.userDataAccessMapper.toRoot(entity.getUser()))
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
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .language(root.getLanguage())
                .isActiveDarkMode(root.getActiveDarkMode())
                .isActiveEmailNotification(root.getActiveEmailNotification())
                .isActiveSmsNotification(root.getActiveSmsNotification())
                .isActivePushNotification(root.getActivePushNotification())
                .isActiveTwoFactorAuthentication(root.getActiveTwoFactorAuthentication())
                .isVisibleLocation(root.getVisibleLocation())
                .isVisibleOnlineStatus(root.getVisibleOnlineStatus())
                .isVisibleLastSeen(root.getVisibleLastSeen())
                .isVisibleProfilePicture(root.getVisibleProfilePicture())
                .isVisibleEmail(root.getVisibleEmail())
                .isVisibleResume(root.getVisibleResume())
                .build();
    }

    @Override
    public UserSettingsEntity toNewEntity(UserSettingsRoot root) {
        return UserSettingsEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .language(root.getLanguage())
                .isActiveDarkMode(root.getActiveDarkMode())
                .isActiveEmailNotification(root.getActiveEmailNotification())
                .isActiveSmsNotification(root.getActiveSmsNotification())
                .isActivePushNotification(root.getActivePushNotification())
                .isActiveTwoFactorAuthentication(root.getActiveTwoFactorAuthentication())
                .isVisibleLocation(root.getVisibleLocation())
                .isVisibleOnlineStatus(root.getVisibleOnlineStatus())
                .isVisibleLastSeen(root.getVisibleLastSeen())
                .isVisibleProfilePicture(root.getVisibleProfilePicture())
                .isVisibleEmail(root.getVisibleEmail())
                .isVisibleResume(root.getVisibleResume())
                .build();
    }
}
