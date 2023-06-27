package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.email.EmailAlreadyExistException;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractEmailDomainService;

import java.util.List;

public class EmailDomainService implements AbstractEmailDomainService {
    @Override
    public void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail) {
        var isExist = existingEmails.contains(newEmail);
        if (isExist) throw new EmailAlreadyExistException();

    }

    @Override
    public void validateForChangeEmail(EmailRoot existingEmail, EmailRoot newEmail) {
        if (existingEmail == null) throw new EmailAlreadyExistException();
        if (existingEmail.getEmail().equals(newEmail.getEmail())) throw new EmailAlreadyExistException();
    }
}
