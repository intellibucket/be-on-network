package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.UserMyAccountResponse;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractUserQueryDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Service;

@Service
public class UserQueryDomainPresentation implements AbstractUserQueryDomainPresentation {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;


    public UserQueryDomainPresentation(AbstractSecurityContextHolder securityContextHolder,
                                       AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
    }

    @Override
    public UserMyAccountResponse myAccount() {
        UserID currentUser = this.securityContextHolder.availableUser();
        var optionalUserRoot = this.userQueryRepositoryAdapter.findById(currentUser);
        if (optionalUserRoot.isPresent()) {
            UserRoot userRoot = optionalUserRoot.get();
            return UserMyAccountResponse.of(userRoot);
        }else throw new AuthDomainPresentationException("F0000000018");
    }
}
