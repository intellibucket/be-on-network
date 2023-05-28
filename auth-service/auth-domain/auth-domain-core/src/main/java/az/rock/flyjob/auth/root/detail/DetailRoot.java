package az.rock.flyjob.auth.root.detail;

import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class DetailRoot extends AggregateRoot<DetailID> {

    private final UserID userID;

    private final Set<RoleRoot> roles;

    private final Boolean isAccountNonExpired;

    private final Boolean isAccountNonLocked;

    private final Boolean isCredentialsNonExpired;

    private final Boolean isEnabled;

    private final Boolean isDeleted;

    private final Boolean isFrozen;

    public UserID getUserID() {
        return userID;
    }

    public Set<RoleRoot> getRoles() {
        return roles;
    }

    public Boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public Boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public Boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public Boolean isFrozen() {
        return isFrozen;
    }

    private DetailRoot(Builder builder) {
        super(builder.detailID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        userID = builder.userID;
        roles = builder.roles;
        isAccountNonExpired = builder.isAccountNonExpired;
        isAccountNonLocked = builder.isAccountNonLocked;
        isCredentialsNonExpired = builder.isCredentialsNonExpired;
        isEnabled = builder.isEnabled;
        isDeleted = builder.isDeleted;
        isFrozen = builder.isFrozen;
    }


    public static final class Builder {
        private DetailID detailID;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private Set<RoleRoot> roles;
        private Boolean isAccountNonExpired;
        private Boolean isAccountNonLocked;
        private Boolean isCredentialsNonExpired;
        private Boolean isEnabled;
        private Boolean isDeleted;
        private Boolean isFrozen;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder detailID(DetailID val) {
            detailID = val;
            return this;
        }

        public Builder detailID(UUID val) {
            detailID = DetailID.of(val);
            return this;
        }

        public Builder version(Long val) {
            version = Version.of(val);
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
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

        public Builder userID(UserID val) {
            userID = val;
            return this;
        }

        public Builder roles(Set<RoleRoot> val) {
            roles = val;
            return this;
        }

        public Builder roles(RoleRoot val) {
            roles = Set.of(val);
            return this;
        }

        public Builder isAccountNonExpired(Boolean val) {
            isAccountNonExpired = val;
            return this;
        }

        public Builder isAccountNonLocked(Boolean val) {
            isAccountNonLocked = val;
            return this;
        }

        public Builder isCredentialsNonExpired(Boolean val) {
            isCredentialsNonExpired = val;
            return this;
        }

        public Builder isEnabled(Boolean val) {
            isEnabled = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder isFrozen(Boolean val) {
            isFrozen = val;
            return this;
        }

        public DetailRoot build() {
            return new DetailRoot(this);
        }
    }
}
