package az.rock.auth.domain.presentation.context;

import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Role;

import java.util.UUID;

public interface AbstractSecurityContextHolder {
    UserID currentUser();

    Language currentLanguage();

    Role currentRoleName();

    String currentUsername();
}
