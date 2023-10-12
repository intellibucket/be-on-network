package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.number.InvalidPhoneNumberException;
import az.rock.flyjob.auth.exception.number.PhoneNumberAlreadyExistException;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractPhoneNumberDomainService;

import java.util.List;

public class PhoneNumberDomainService implements AbstractPhoneNumberDomainService {
    @Override
    public PhoneNumberRoot validatePhoneNumber(List<PhoneNumberRoot> savedPhoneNumbers, PhoneNumberRoot newPhoneNumber) {
        if (savedPhoneNumbers.contains(newPhoneNumber)) throw new PhoneNumberAlreadyExistException();
        if (!newPhoneNumber.isValid()) throw new InvalidPhoneNumberException();
        return newPhoneNumber;
    }
}
