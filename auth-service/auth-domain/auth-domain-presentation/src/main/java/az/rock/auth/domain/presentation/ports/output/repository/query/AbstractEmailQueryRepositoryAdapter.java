package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.Optional;

public interface AbstractEmailQueryRepositoryAdapter {
    Optional<EmailRoot> findMyEmailByID(UserID userID,EmailID emailID);
    Optional<EmailRoot> findAnyByByID(EmailID emailID);
    List<EmailRoot> findAllMyEmails(UserID userID);
    List<EmailID> findAllMyEmailsID(UserID userID);

    Boolean isExistEmailAsActive(String email);
}
