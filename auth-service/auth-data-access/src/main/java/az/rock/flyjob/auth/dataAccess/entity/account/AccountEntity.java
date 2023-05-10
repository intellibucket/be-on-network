package az.rock.flyjob.auth.dataAccess.entity.account;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.flyjob.auth.dataAccess.entity.account.RoleEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts", schema = "auth")
@Entity(name = "AccountEntity")
public class AccountEntity extends BaseEntity {

    @OneToOne
    private UserEntity userEntity;


    @Singular
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "account_role", schema = "auth", joinColumns = {
            @JoinColumn(name = "ACCOUNT_UUID", referencedColumnName = "UUID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_UUID", referencedColumnName = "UUID")})
    private Set<RoleEntity> roles;

}
