package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;
import java.util.Optional;
@DomainOutputPort
public interface AbstractPhoneNumberQueryRepositoryAdapter {
    Optional<PhoneNumberRoot> findOwnByID(UserID userID, PhoneNumberID phoneNumberID);
    List<PhoneNumberRoot> findOwnAllByID(UserID userID);

    Boolean isExistVerifiedPhoneNumber(UserID currentUser);
}
