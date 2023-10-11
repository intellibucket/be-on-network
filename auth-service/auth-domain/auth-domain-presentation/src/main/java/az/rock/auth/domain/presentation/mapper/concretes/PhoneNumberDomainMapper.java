package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPhoneNumberDomainMapper;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDomainMapper implements AbstractPhoneNumberDomainMapper {

    @Override
    public PhoneNumberRoot toRoot(PhoneNumberCommandRequest request) {
        return null;
    }
}
