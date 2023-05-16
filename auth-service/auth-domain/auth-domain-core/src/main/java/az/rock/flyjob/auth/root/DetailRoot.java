package az.rock.flyjob.auth.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.Set;

public class DetailRoot extends AggregateRoot<DetailID> {

    private final UserRoot user;

    private final Set<RoleRoot> roles;

    public DetailRoot(DetailID detailID,
                      Long version,
                      ProcessStatus processStatus,
                      DataStatus dataStatus,
                      ZonedDateTime createdDate,
                      ZonedDateTime modificationDate,
                      UserRoot user,
                      Set<RoleRoot> roles) {
        super(detailID, version, processStatus, dataStatus, createdDate, modificationDate);
        this.user = user;
        this.roles = roles;
    }

    private DetailRoot(Builder builder) {
        super(builder.detailID, builder.version, builder.processStatus, builder.dataStatus, builder.createdDate, builder.modificationDate);
        user = builder.user;
        roles = builder.roles;
    }

    public UserRoot getUserRoot() {
        return user;
    }

    public Set<RoleRoot> getRoles() {
        return roles;
    }


    public static final class Builder {
        private DetailID detailID;
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

        public Builder accountID(DetailID val) {
            detailID = val;
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

        public DetailRoot build() {
            return new DetailRoot(this);
        }
    }
}
