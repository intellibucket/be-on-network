package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;

import java.util.List;

public interface AbstractPhoneNumberDomainService {
    PhoneNumberRoot validatePhoneNumber(List<PhoneNumberRoot> allInterests, PhoneNumberRoot newPhoneNumber);

}
