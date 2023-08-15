package az.rock.auth.domain.presentation.security;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Role;
import az.rock.lib.valueObject.UserType;

public interface AbstractSecurityContextHolder {

    UserID currentUser();

    UserID availableUser();

    Language currentLanguage();

    Boolean accountIsNotLocked();

    Role currentRoleName();

    String currentUsername();

    Boolean isAnonymous();

    Boolean isAuthenticated();

    UserType currentUserType();
}
