package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.AccessDeniedDomainException;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractPasswordDomainService;
import az.rock.lib.domain.id.UserID;

public class PasswordDomainService implements AbstractPasswordDomainService {
    @Override
    public void validateAndInitialize(UserID currentUserId, PasswordRoot oldPasswordRoot, PasswordRoot newPasswordRoot) {
        if (!currentUserId.equals(oldPasswordRoot.getUserID())) throw new AccessDeniedDomainException();
    }
}
