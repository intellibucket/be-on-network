package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.user.EmailRoot;

import java.util.List;

public interface AbstractEmailDomainService {
    void validateNewEmail(List<EmailRoot> existingEmails, EmailRoot newEmail);
}
