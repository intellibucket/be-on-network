package az.rock.flyjob.auth.dataAccess.entity;

import az.rock.flyjob.auth.dataAccess.entity.account.AccountEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "user", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "key", nullable = false, unique = true)
    private UUID key;

    @Column(name = "first_name", nullable = false)
    @Min(value = 3, message = "First name must be at least 3 characters long")
    @Max(value = 30, message = "First name must be at most 20 characters long")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Min(value = 3, message = "Last name must be at least 3 characters long")
    @Max(value = 40, message = "Last name must be at most 20 characters long")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    @Min(value = 2, message = "Username must be at least 3 characters long")
    @Max(value = 30, message = "Username must be at most 20 characters long")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private PasswordEntity passwordEntity;

    @Column(name = "timezone", nullable = false)
    @Min(value = 1, message = "Timezone must be at least 3 characters long")
    private String timezone;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountEntity account;

}
