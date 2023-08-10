package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPasswordDomainMapper;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.AbstractPasswordEncryptor;
import az.rock.lib.domain.id.auth.PasswordID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordDomainMapper implements AbstractPasswordDomainMapper {
    private final AbstractPasswordEncryptor passwordEncryptor;

    public PasswordDomainMapper(AbstractPasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    @Override
    public PasswordRoot generatePasswordRoot(UserID userID, String rawPassword) {
        var salt = UUID.randomUUID().toString();
        var encryptedPassword = this.passwordEncryptor.encrypt(rawPassword,salt);
        return PasswordRoot.Builder
                .builder()
                .id(PasswordID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .userID(userID)
                .salt(salt)
                .hash(encryptedPassword)
                .build();
    }
}
