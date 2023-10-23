package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.AccessDeniedDomainException;
import az.rock.flyjob.auth.exception.password.IncorrectOldPasswordException;
import az.rock.flyjob.auth.exception.password.SamePasswordOnChangeException;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractPasswordDomainService;
import az.rock.lib.AbstractPasswordEncryptor;
import az.rock.lib.domain.id.auth.UserID;

public class PasswordDomainService implements AbstractPasswordDomainService {
    private final AbstractPasswordEncryptor passwordEncryptor;

    public PasswordDomainService(AbstractPasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    @Override
    public void validateAndInitialize(UserID currentUserId, PasswordRoot oldPasswordRoot, PasswordRoot newPasswordRoot, String oldPasswordOnRequest) {
        if (!currentUserId.equals(oldPasswordRoot.getUserID())) throw new AccessDeniedDomainException();
        var result = this.passwordEncryptor.matches(oldPasswordOnRequest, oldPasswordRoot.getHash());
        if (!result) throw new IncorrectOldPasswordException();
        if (this.passwordEncryptor.matches(oldPasswordOnRequest, newPasswordRoot.getHash())) throw new SamePasswordOnChangeException();
    }
}
