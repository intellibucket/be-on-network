package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.AccessDeniedDomainException;
import az.rock.flyjob.auth.exception.email.EmailAlreadyExistException;
import az.rock.flyjob.auth.exception.email.EmailMaxCountException;
import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractEmailDomainService;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.SwitchCase;

import java.util.List;

public class EmailDomainService implements AbstractEmailDomainService {

    @Override
    public void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail) {
        var isExist = existingEmails.contains(newEmail);
        var countOfActiveEmails = existingEmails.stream()
                .filter(EmailRoot::isActive)
                .count();
        if (countOfActiveEmails > 3) throw new EmailMaxCountException();
        if (isExist) throw new EmailAlreadyExistException();
    }

    @Override
    public void validateForChangeEmail(EmailRoot existingEmail, EmailRoot newEmail) {
        if (existingEmail == null) throw new EmailAlreadyExistException();
        if (existingEmail.getEmail().equals(newEmail.getEmail())) throw new EmailAlreadyExistException();
    }

    @Override
    public void validateForDeleteEmail(UserID userID, EmailRoot emailRoot) {
        if (!emailRoot.isOwned(userID)) throw new AccessDeniedDomainException();
    }

    @Override
    public EmailRoot validateForSetPrimaryEmail(UserID currentUserId, EmailRoot emailRoot) {
        if (!emailRoot.isOwned(currentUserId)) throw new AccessDeniedDomainException();
        return emailRoot.changePrimary();
    }

    @Override
    public EmailRoot validateAndInitializeEmailNotification(UserID currentUserId,
                                                            EmailRoot emailRoot,
                                                            SwitchCase switchCase) {
        if (!emailRoot.isOwned(currentUserId)) throw new AccessDeniedDomainException();
        return emailRoot.changeEmailNotification(switchCase);
    }

    @Override
    public EmailRoot validateAndInitializeEmailSubscribedPromotions(UserID currentUserId, EmailRoot emailRoot, SwitchCase switchCase) {
        if (!emailRoot.isOwned(currentUserId)) throw new AccessDeniedDomainException();
        return emailRoot.changeEmailSubscribedPromotions(switchCase);
    }
}
