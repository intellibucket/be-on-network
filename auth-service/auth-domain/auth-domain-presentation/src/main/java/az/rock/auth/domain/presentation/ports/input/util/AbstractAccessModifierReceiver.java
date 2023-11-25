package az.rock.auth.domain.presentation.ports.input.util;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;

public interface AbstractAccessModifierReceiver {
    List<AccessModifier> fetchAccessModifiers(UserID authenticatedUserId, UserID targetUserID);

}
