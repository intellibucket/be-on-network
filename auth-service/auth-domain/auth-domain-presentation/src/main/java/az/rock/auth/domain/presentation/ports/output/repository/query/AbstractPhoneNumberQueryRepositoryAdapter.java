package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.PhoneNumberID;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AbstractPhoneNumberQueryRepositoryAdapter {
    Optional<PhoneNumberRoot> findOwnByID(UserID userID, PhoneNumberID phoneNumberID);
    Optional<PhoneNumberRoot> findAnyByID(PhoneNumberID phoneNumberID);
    List<PhoneNumberRoot> findOwnAllByID(UserID userID);
    List<UUID> findOwnAllUUIDByID(UserID userID);
}
