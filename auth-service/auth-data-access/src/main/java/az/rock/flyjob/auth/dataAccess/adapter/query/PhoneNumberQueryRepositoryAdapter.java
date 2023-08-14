package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPhoneNumberQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PhoneNumberQueryRepositoryAdapter implements AbstractPhoneNumberQueryRepositoryAdapter {
    @Override
    public Optional<PhoneNumberRoot> findOwnByID(UserID userID, PhoneNumberID phoneNumberID) {
        return Optional.empty();
    }

    @Override
    public Optional<PhoneNumberRoot> findAnyByID(PhoneNumberID phoneNumberID) {
        return Optional.empty();
    }

    @Override
    public List<PhoneNumberRoot> findOwnAllByID(UserID userID) {
        return null;
    }

    @Override
    public List<UUID> findOwnAllUUIDByID(UserID userID) {
        return null;
    }
}
