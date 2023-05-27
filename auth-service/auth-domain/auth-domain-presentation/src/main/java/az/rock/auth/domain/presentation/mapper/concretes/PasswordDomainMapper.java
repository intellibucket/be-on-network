package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPasswordDomainMapper;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.AbstractPasswordEncryptor;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordDomainMapper implements AbstractPasswordDomainMapper {
    private final AbstractPasswordEncryptor passwordEncryptor;

    public PasswordDomainMapper(AbstractPasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    @Override
    public PasswordRoot toNewPasswordRoot(UserID userID,String rawPassword) {
        var salt = UUID.randomUUID().toString();
        var encryptedPassword = this.passwordEncryptor.encrypt(rawPassword,salt);
        return PasswordRoot.of(userID,salt,encryptedPassword);
    }
}
