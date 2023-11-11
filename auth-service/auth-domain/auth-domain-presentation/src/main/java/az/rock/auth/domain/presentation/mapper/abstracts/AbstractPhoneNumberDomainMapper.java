package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractPhoneNumberDomainMapper {
    PhoneNumberRoot toNewRoot(UserID userID, PhoneNumberCommandRequest request);
}
