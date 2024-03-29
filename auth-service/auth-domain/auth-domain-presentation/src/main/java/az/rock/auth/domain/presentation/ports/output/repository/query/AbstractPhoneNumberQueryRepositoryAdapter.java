package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;

@DomainOutputPort
public interface AbstractPhoneNumberQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<PhoneNumberRoot, PhoneNumberID, UserID> {
    Boolean isExistVerifiedPhoneNumber(PhoneNumberRoot phoneNumberRoot);
}
