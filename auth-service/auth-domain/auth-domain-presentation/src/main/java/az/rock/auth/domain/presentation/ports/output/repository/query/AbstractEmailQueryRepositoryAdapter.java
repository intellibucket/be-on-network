package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;
import java.util.Optional;
@DomainOutputPort
public interface AbstractEmailQueryRepositoryAdapter {
    Optional<EmailRoot> findMyEmailByID(UserID userID,EmailID emailID);
    Optional<EmailRoot> findAnyByByID(EmailID emailID);
    List<EmailRoot> findAllMyEmails(UserID userID);
    List<EmailID> findAllMyEmailsID(UserID userID);

    Boolean isExistEmailAsActive(String email);
}
