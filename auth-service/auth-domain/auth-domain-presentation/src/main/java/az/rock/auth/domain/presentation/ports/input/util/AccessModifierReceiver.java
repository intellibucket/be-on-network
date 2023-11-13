package az.rock.auth.domain.presentation.ports.input.util;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccessModifierReceiver implements AbstractAccessModifierReceiver{

    @Override
    public List<AccessModifier> fetchAccessModifiers(UserID authenticatedUserId, UserID targetUserID) {
        if (authenticatedUserId == null) return List.of();
        if (authenticatedUserId.equals(targetUserID)) return AccessModifier.fetchAll();
        return null;
    }
}
