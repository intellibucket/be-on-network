package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserSettingsDomainMapper;
import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.auth.UserSettingsID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserSettingsDomainMapper implements AbstractUserSettingsDomainMapper {
    public UserSettingsRoot defaultUserSettingsRoot(UserID userID) {
        return UserSettingsRoot.Builder
                .builder()
                .userSettingsID(UserSettingsID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .userID(userID)
                .build();
    }
}
