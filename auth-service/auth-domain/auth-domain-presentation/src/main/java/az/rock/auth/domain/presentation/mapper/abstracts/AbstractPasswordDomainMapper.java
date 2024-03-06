package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.user.PasswordRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractPasswordDomainMapper {
    PasswordRoot generatePasswordRoot(UserID userID, String rawPassword);

}
