package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.domain.id.UserID;

public interface AbstractPasswordDomainMapper {
    PasswordRoot toNewPasswordRoot(UserID userID,String rawPassword);
}
