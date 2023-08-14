package az.rock.flyjob.js.domain.presentation.security;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Role;

public interface AbstractSecurityContextHolder {

    UserID availableUser();

    ResumeID resumeID();

    Language currentLanguage();

    Boolean accountIsNotLocked();

    Role currentRoleName();

    String currentUsername();

    Boolean isAnonymous();

    Boolean isAuthenticated();
}
