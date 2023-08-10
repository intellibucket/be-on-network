package az.rock.flyjob.auth.root.security;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.AuthorityID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.Set;

public class AuthorityRoot extends AggregateRoot<AuthorityID> {

    private final String permission;

    private final String description;

    private final Set<RoleRoot> roles;

    public AuthorityRoot(AuthorityID authorityID,
                         Long version,
                         ProcessStatus processStatus,
                         RowStatus rowStatus,
                         ZonedDateTime createdDate,
                         ZonedDateTime modificationDate,
                         String permission,
                         String description,
                         Set<RoleRoot> roles) {
        super(authorityID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.permission = permission;
        this.description = description;
        this.roles = roles;
    }

    private AuthorityRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        permission = builder.permission;
        description = builder.description;
        roles = builder.roles;
    }

    public Set<RoleRoot> getRoles() {
        return roles;
    }

    public String getPermission() {
        return permission;
    }

    public String getDescription() {
        return description;
    }

    public static final class Builder {
        private AuthorityID id;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private String permission;
        private String description;
        private Set<RoleRoot> roles;

        private Builder() {
        }


        public static Builder builder() {
            return new Builder();
        }


        public Builder id(AuthorityID val) {
            id = val;
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

        public Builder dataStatus(RowStatus val) {
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

        public Builder permission(String val) {
            permission = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder roles(Set<RoleRoot> val) {
            roles = val;
            return this;
        }

        public AuthorityRoot build() {
            return new AuthorityRoot(this);
        }
    }
}
