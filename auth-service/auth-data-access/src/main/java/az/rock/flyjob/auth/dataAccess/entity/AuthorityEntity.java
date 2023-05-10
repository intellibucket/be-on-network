package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.flyjob.auth.dataAccess.entity.account.RoleEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Example 1
 * - Permission *.auth.account.public.read
 * - Bütün istifadəçilərin profillərinə baxa bilmək
 * Example 2
 * - Permission *.auth.account.private.read
 * - Bütün istifadəçilərin profillərinə və şəxsi məlumatlarına baxa bilmək
 * Example 3
 * - Permission own.auth.account.private.read
 * - İstifadəçinin öz profil məlumatlarına detallı baxa bilməsi
 * Example 3
 * - Permission *.user.post.public.read
 * - Bütün istifadəçilərin postlarına baxa bilmək
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities", schema = "auth")
@Entity(name = "AuthorityEntity")
public class AuthorityEntity extends BaseEntity {

    @Column(name = "permission", nullable = false, unique = true)
    private String permission;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<RoleEntity> roles;

    private AuthorityEntity(Builder builder) {
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        setPermission(builder.permission);
        setRoles(builder.roles);
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String permission;
        private Set<RoleEntity> roles;

        private Builder() {
        }

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public Builder withCreatedDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withLastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder withPermission(String permission) {
            this.permission = permission;
            return this;
        }

        public Builder withRoles(Set<RoleEntity> roles) {
            this.roles = roles;
            return this;
        }

        public AuthorityEntity build() {
            return new AuthorityEntity(this);
        }
    }
}
