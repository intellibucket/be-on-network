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

    private AccountRoot(Builder builder) {
        super(builder.accountID, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        user = builder.user;
        roles = builder.roles;
    }

    public UserRoot getUser() {
        return user;
    }

    public Set<RoleRoot> getRoles() {
        return roles;
    }


    public static final class Builder {
        private AccountID accountID;
        private Long version;
        private ProcessStatus processStatus;
        private DataStatus dataStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserRoot user;
        private Set<RoleRoot> roles;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder accountID(AccountID val) {
            accountID = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder modificationDate(ZonedDateTime val) {
            modificationDate = val;
            return this;
        }

        public Builder user(UserRoot val) {
            user = val;
            return this;
        }

        public Builder roles(Set<RoleRoot> val) {
            roles = val;
            return this;
        }

        public AccountRoot build() {
            return new AccountRoot(this);
        }
    }
}
