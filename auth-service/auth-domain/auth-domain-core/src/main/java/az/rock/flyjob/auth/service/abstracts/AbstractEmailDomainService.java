package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.SwitchCase;

import java.util.List;

public interface AbstractEmailDomainService {
    void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail);
    void validateForChangeEmail(EmailRoot existingEmail, EmailRoot newEmail);

    void validateForDeleteEmail(UserID userID,EmailRoot emailRoot);

    EmailRoot validateForSetPrimaryEmail(UserID currentUserId, EmailRoot emailRoot);

    EmailRoot validateAndInitializeEmailNotification(UserID currentUserId,EmailRoot emailRoot, SwitchCase switchCase);

    EmailRoot validateAndInitializeEmailSubscribedPromotions(UserID currentUserId, EmailRoot emailRoot, SwitchCase switchCase);
}
