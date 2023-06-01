package az.rock.auth.domain.presentation.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.UserSettingResponse;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserSettingsRepositoryAdapter;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractUserSettingsQueryDomainPresentationService;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsQueryDomainPresentationService implements AbstractUserSettingsQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractUserSettingsRepositoryAdapter userRepositoryAdapter;

    public UserSettingsQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder, AbstractUserSettingsRepositoryAdapter userRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.userRepositoryAdapter = userRepositoryAdapter;
    }

    @Override
    public UserSettingResponse getUserSettings() {
        UserID currentUserId = this.securityContextHolder.currentUser();
        var settingsRoot = this.userRepositoryAdapter.findByUserId(currentUserId);
        return UserSettingResponse.of(settingsRoot);
    }
}
