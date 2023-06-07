package az.rock.flyjob.auth.root;

import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

public class RoleRoot extends AggregateRoot<RoleID> {

    private final String name;
    private final String description;
    private final Set<AuthorityRoot> authorities;

    private final Set<DetailID> details;


    public RoleRoot(RoleID roleID,
                    Long version,
                    ProcessStatus processStatus,
                    RowStatus rowStatus,
                    ZonedDateTime createdDate,
                    ZonedDateTime modificationDate,
                    DetailRoot account,
                    String name,
                    String description,
                    Set<AuthorityRoot> authorities,
                    Set<DetailID> details) {
        super(roleID, version, processStatus, rowStatus, createdDate, modificationDate);
        this.name = name;
        this.description = description;
        this.authorities = authorities;
        this.details = details;
    }

    public void addDetail(DetailID detailID) {
        details.add(detailID);
    }

    private RoleRoot(Builder builder) {
        super(builder.roleID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.modificationDate);
        name = builder.name;
        description = builder.description;
        authorities = builder.authorities;
        details = builder.details;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<AuthorityRoot> getAuthorities() {
        return authorities;
    }

    public static final class Builder {
        private RoleID roleID;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;

        private String name;
        private String description;

        private Set<AuthorityRoot> authorities = new HashSet<>();

        private Set<DetailID> details = new HashSet<>();

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder roleID(RoleID val) {
            roleID = val;
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

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder details(Set<DetailID> val) {
            details = val;
            return this;
        }

        public Builder details(DetailID val) {
            details = Set.of(val);
            return this;
        }

        public Builder authorities(Set<AuthorityRoot> val) {
            authorities = val;
            return this;
        }

        public RoleRoot build() {
            return new RoleRoot(this);
        }
    }
}
