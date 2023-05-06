package az.rock.flyjob.auth.dataAccess.entity.account;

import az.rock.flyjob.auth.dataAccess.entity.AuthorityEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles", schema = "user")
@Entity
public class RoleEntity extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<AccountEntity> userAccounts;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority", schema = "user",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "UUID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "UUID")})
    private Set<AuthorityEntity> authorities;
}
