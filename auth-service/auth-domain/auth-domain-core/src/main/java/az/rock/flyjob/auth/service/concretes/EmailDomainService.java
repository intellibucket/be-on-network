package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.EmailAlreadyExistException;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractEmailDomainService;

import java.util.List;

public class EmailDomainService implements AbstractEmailDomainService {
    @Override
    public void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail) {
        var isExist = existingEmails.contains(newEmail);
        if (isExist) throw new EmailAlreadyExistException();

    }
}
