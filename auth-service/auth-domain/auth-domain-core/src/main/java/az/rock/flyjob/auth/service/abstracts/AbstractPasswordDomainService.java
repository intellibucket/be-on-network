package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractPasswordDomainService {
    void validateAndInitialize(UserID currentUserId,PasswordRoot oldPasswordRoot,PasswordRoot newPasswordRoot);
}
