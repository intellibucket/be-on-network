package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;

public interface AbstractPhoneNumberDomainMapper {
    PhoneNumberRoot toRoot(PhoneNumberCommandRequest request);
}
