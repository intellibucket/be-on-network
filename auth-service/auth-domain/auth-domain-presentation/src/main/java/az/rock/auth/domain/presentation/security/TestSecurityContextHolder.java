package az.rock.auth.domain.presentation.security;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Role;
import az.rock.lib.valueObject.UserType;
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

    @Value("${test.values.user.role.name:ROLE_JOB_SEEKER}")
    private String testRoleName;

    @Value("${test.values.user.username}")
    private String testUsername;

    @Value("${test.values.user.isAnonymous:false}")
    private Boolean isAnonymous ;
    @Value("${test.values.user.isAuthenticated:true}")
    private Boolean isAuthenticated ;

    @Override
    public UserID currentUser() {
        return UserID.of(UUID.fromString(testUserUUID));
    }

    @Override
    public UserID availableUser() {
        var userID = this.currentUser();
        var availableUser = Boolean.TRUE;
        if (availableUser) {
            return userID;
        }else throw new RuntimeException("User is not available");
    }
    @Override
    public Language currentLanguage() {
        return Language.valueOf(this.testLanguage.toUpperCase());
    }

    @Override
    public Boolean accountIsNotLocked() {
        return Boolean.FALSE;
    }

    public Role currentRoleName() {
        return Role.valueOf(this.testRoleName);
    }
    @Override
    public String currentUsername() {
        return this.testUsername;
    }

    @Override
    public Boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override
    public Boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public UserType currentUserType() {
        return UserType.JOB_SEEKER;
    }
}
