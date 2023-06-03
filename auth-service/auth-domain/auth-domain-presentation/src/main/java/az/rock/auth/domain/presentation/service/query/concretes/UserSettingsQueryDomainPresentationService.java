package az.rock.auth.domain.presentation.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.UserSettingModelResponse;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractUserSettingsQueryDomainPresentationService;
import az.rock.lib.domain.id.UserID;
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
    public UserSettingModelResponse getUserSettings() {
        UserID currentUserId = this.securityContextHolder.currentUser();
        var settingsRoot = this.userSettingsQueryRepositoryAdapter.findByPID(currentUserId);
        return UserSettingModelResponse.of(settingsRoot);
    }
}
