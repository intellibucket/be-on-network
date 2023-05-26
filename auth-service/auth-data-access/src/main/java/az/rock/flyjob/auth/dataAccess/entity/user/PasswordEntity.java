package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passwords", schema = "auth")
@Entity(name = "PasswordEntity")
public class PasswordEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "hash", nullable = false)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$", message = "Invalid password")
    private String hash;


}
