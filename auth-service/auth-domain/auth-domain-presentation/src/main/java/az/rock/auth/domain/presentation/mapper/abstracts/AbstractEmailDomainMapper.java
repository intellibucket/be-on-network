package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.UserID;

public interface AbstractEmailDomainMapper {
    EmailRoot toNewEmailRoot(UserID userID,String email);
}
