package az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user;

import az.rock.auth.domain.presentation.dto.response.user.MyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.UserMyAccountResponse;
import az.rock.flyjob.auth.model.query.UserProfileQueryRecord;
import az.rock.lib.annotation.InputPort;

@InputPort
public interface AbstractUserQueryDomainPresentation {
    UserMyAccountResponse myAccount();

    MyUserProfileResponse myProfile();
}
