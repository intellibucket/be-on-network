package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractEmailDomainMapper {
    EmailRoot toNewEmailRoot(UserID userID,String email);

    EmailRoot toNewEmailRoot(UserID userID,EmailCreateRequest emailCreateRequest);

    EmailRoot mapToEmailRoot(EmailRoot oldEmail ,EmailChangeRequest emailChangeRequest);

}
