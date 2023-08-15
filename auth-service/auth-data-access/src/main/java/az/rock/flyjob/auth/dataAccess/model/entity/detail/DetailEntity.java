package az.rock.flyjob.auth.dataAccess.model.entity.detail;

import az.rock.flyjob.auth.dataAccess.model.entity.RoleEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "details", schema = "auth")
@Entity(name = "DetailEntity")
public class DetailEntity extends BaseEntity {

    @OneToOne
    private UserEntity user;

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "detail_role", schema = "auth", joinColumns = {
            @JoinColumn(name = "DETAIL_UUID", referencedColumnName = "UUID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_UUID", referencedColumnName = "UUID")})
    private Set<RoleEntity> roles;

    @Column(name = "is_account_non_expired", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", nullable = false, columnDefinition = "boolean default true")
    private Boolean isCredentialsNonExpired;

    @Column(name = "is_enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean isEnabled;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "is_frozen", nullable = false, columnDefinition = "boolean default false")
    private Boolean isFrozen;

    private DetailEntity(Builder builder) {
        setUser(builder.user);
        setRoles(builder.roles);
        setIsAccountNonExpired(builder.isAccountNonExpired);
        setIsAccountNonLocked(builder.isAccountNonLocked);
        setIsCredentialsNonExpired(builder.isCredentialsNonExpired);
        setIsEnabled(builder.isEnabled);
        setIsDeleted(builder.isDeleted);
        setIsFrozen(builder.isFrozen);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity user;
        private Set<RoleEntity> roles;
        private Boolean isAccountNonExpired;
        private Boolean isAccountNonLocked;
        private Boolean isCredentialsNonExpired;
        private Boolean isEnabled;
        private Boolean isDeleted;
        private Boolean isFrozen;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder roles(Set<RoleEntity> val) {
            roles = val;
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

        public Builder rowStatus(RowStatus val) {
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

        public DetailEntity build() {
            return new DetailEntity(this);
        }
    }
}
