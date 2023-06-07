package az.rock.auth.domain.presentation.context;

import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.Language;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Profile({"local"})
@Component
public class TestSecurityContextHolder implements AbstractSecurityContextHolder{
    @Value("${test.values.user.uuid}")
    private String testUserUUID;

    @Value("${test.values.user.language:EN}")
    private String testLanguage;

    public UserID currentUser() {
        return UserID.of(UUID.fromString(testUserUUID));
    }

    @Override
    public Language currentLanguage() {
        return Language.valueOf(this.testLanguage.toUpperCase());
    }
}
