package az.rock.auth.domain.presentation.ports.input.service.query.concretes.user;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.UserSettingModelResponse;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractUserSettingsQueryDomainPresentationService;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsQueryDomainPresentationService implements AbstractUserSettingsQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractUserSettingsQueryRepositoryAdapter userSettingsQueryRepositoryAdapter;

    public UserSettingsQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                      AbstractUserSettingsQueryRepositoryAdapter userSettingsQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.userSettingsQueryRepositoryAdapter = userSettingsQueryRepositoryAdapter;
    }

    @Override
    public UserSettingModelResponse currentUserSettings() {
        UserID currentUserId = this.securityContextHolder.availableUser();
        var settingsRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserId);
        return UserSettingModelResponse.of(settingsRoot.orElseThrow(() -> new RuntimeException("F0000000001")));
    }
}
