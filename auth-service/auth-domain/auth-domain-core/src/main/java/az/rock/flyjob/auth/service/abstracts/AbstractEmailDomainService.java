package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.SwitchCase;

import java.util.List;

public interface AbstractEmailDomainService {
    void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail);
    void validateForChangeEmail(EmailRoot existingEmail, EmailRoot newEmail);

    void validateForDeleteEmail(UserID userID,EmailRoot emailRoot);

    EmailRoot validateForSetPrimaryEmail(UserID currentUserId, EmailRoot emailRoot);
}
