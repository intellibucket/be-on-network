package az.rock.flyjob.auth.root.account;

import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.AccountID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.Set;

public class AccountRoot extends AggregateRoot<AccountID> {

    private final UserRoot user;

    private final Set<RoleRoot> roles;

    public AccountRoot(AccountID accountID,
                       Long version,
                       ProcessStatus processStatus,
                       DataStatus dataStatus,
                       ZonedDateTime createdDate,
                       ZonedDateTime modificationDate,
                       UserRoot user,
                       Set<RoleRoot> roles) {
        super(accountID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.user = user;
        this.roles = roles;
    }
}
