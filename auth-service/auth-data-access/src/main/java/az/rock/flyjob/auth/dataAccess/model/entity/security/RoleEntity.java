package az.rock.flyjob.auth.dataAccess.model.entity.security;

import az.rock.flyjob.auth.dataAccess.model.entity.detail.DetailEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles", schema = "auth")
@Entity
public class RoleEntity extends BaseEntity {
    private String name;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<DetailEntity> userDetails;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority", schema = "auth",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "UUID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "UUID")})
    private Set<AuthorityEntity> authorities;

    public void addDetailEntity(DetailEntity entity){
        if (this.userDetails == null) this.userDetails = Set.of(entity);
        else this.userDetails.add(entity);
        //entity.getRoles().add(this);
    }

    private RoleEntity(Builder builder) {
        setName(builder.name);
        setDescription(builder.description);
        setUserDetails(builder.userAccounts);
        setAuthorities(builder.authorities);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private String name;
        private String description;
        private Set<DetailEntity> userAccounts;
        private Set<AuthorityEntity> authorities;
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder userAccounts(Set<DetailEntity> val) {
            userAccounts = val;
            return this;
        }

        public Builder authorities(Set<AuthorityEntity> val) {
            authorities = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
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

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public RoleEntity build() {
            return new RoleEntity(this);
        }
    }
}
