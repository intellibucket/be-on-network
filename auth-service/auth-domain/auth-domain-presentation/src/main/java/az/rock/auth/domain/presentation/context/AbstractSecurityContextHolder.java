package az.rock.auth.domain.presentation.context;

import az.rock.lib.domain.id.UserID;

import java.util.UUID;

public interface AbstractSecurityContextHolder {
    UserID currentUser();
}
