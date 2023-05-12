package az.rock.flyjob.auth.dataAccess.entity.detail;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
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
@Table(name = "accounts", schema = "auth")
@Entity(name = "AccountEntity")
public class DetailEntity extends BaseEntity {

    @OneToOne
    private UserEntity userEntity;


    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "account_role", schema = "auth", joinColumns = {
            @JoinColumn(name = "ACCOUNT_UUID", referencedColumnName = "UUID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_UUID", referencedColumnName = "UUID")})
    private Set<RoleEntity> roles;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private Boolean isEnabled;

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
