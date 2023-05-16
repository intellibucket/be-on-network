package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.lib.domain.BaseEntity;
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
    private UserEntity userEntity;

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
        setUserEntity(builder.userEntity);
        setRoles(builder.roles);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UserEntity userEntity;
        private Set<RoleEntity> roles;
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userEntity(UserEntity val) {
            userEntity = val;
            return this;
        }

        public Builder roles(Set<RoleEntity> val) {
            roles = val;
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
