package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.user.PhoneNumberRoot;

import java.util.List;

public interface AbstractPhoneNumberDomainService {
    PhoneNumberRoot validateNewPhoneNumber(List<PhoneNumberRoot> savedPhoneNumbers, PhoneNumberRoot newPhoneNumber);
}
